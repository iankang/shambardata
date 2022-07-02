package com.example.shambadata.data

import com.example.shambadata.models.*
import com.example.shambadata.models.models_ui.FarmItem

class DataWrangler(
    private val shambaDataJson: ShambaDataResponse,
    private val liveStockBreedResponse: LiveStockBreedResponse,
    private val livestockCategory: LiveStockCategoryResponse,
    private val counties: CountiesResponse
) {
    var farmMap = mutableMapOf<Int, FarmItem>()
    var animalMap = mutableMapOf<Int, AnimalItem>()
    var scheduleMap = mutableMapOf<Int, Schedule>()
    var livestockMap = mutableMapOf<Int, LiveStockCategoryResponseItem>()
    var countiesMap = mutableMapOf<Int, CountiesResponseItem>()
    var breedIdLivestockBreedAndLivestockCategory = mutableMapOf<Int, LivestockAndBreedItem>()
    var livestockIdBreedAndLivestockItem = mutableMapOf<Int, MutableSet<LivestockAndBreedItem>>()


    var county: CountiesResponseItem? = null

    init {
        initializeDataMaps()
    }

    private fun initializeDataMaps() {

        shambaDataJson.forEach { shambaDataResponseItem: ShambaDataResponseItem ->
            val farmItem = shambaDataResponseItem.toFarmItem()
            farmItem.animals = shambaDataResponseItem.animals?.map { item -> item.toAnimalItem() }
            farmItem.schedule = shambaDataResponseItem.schedule
            farmMap[shambaDataResponseItem.farmId?.toInt()!!] = shambaDataResponseItem.toFarmItem()
        }

        shambaDataJson.forEach { shambaDataResponseItem: ShambaDataResponseItem ->
            shambaDataResponseItem.animals?.forEach { animal: Animal ->
                val animalItem: AnimalItem = animal.toAnimalItem()
                animalItem.farmItem = shambaDataResponseItem.toFarmItem()
                animalItem.livestockAndBreedItem =
                    breedIdLivestockBreedAndLivestockCategory[animal.breed?.toInt()]
                animalMap[animal.animalId?.toInt()!!] = animalItem
            }
        }

        shambaDataJson.forEach { shambaDataResponseItem: ShambaDataResponseItem ->
            shambaDataResponseItem.schedule?.forEach { schedule: Schedule ->
                scheduleMap[schedule.scheduleId?.toInt()!!] = schedule
            }
        }

        liveStockBreedResponse.forEach { liveStockBreedResponseItem: LiveStockBreedResponseItem ->
            breedIdLivestockBreedAndLivestockCategory[liveStockBreedResponseItem.id!!] =
                liveStockBreedResponseItem.toLivestockAndBreed()
        }

        livestockCategory.forEach { liveStockCategoryResponseItem: LiveStockCategoryResponseItem ->
            livestockMap[liveStockCategoryResponseItem.id!!] = liveStockCategoryResponseItem
        }

        counties.forEach { countiesResponseItem: CountiesResponseItem ->
            countiesMap[countiesResponseItem.code!!] = countiesResponseItem
        }

        livestockCategory.forEach { liveStockCategoryResponseItem: LiveStockCategoryResponseItem ->
            val filteredMap =
                breedIdLivestockBreedAndLivestockCategory.filterValues { livestockAndBreedItem: LivestockAndBreedItem -> livestockAndBreedItem.categoryId == liveStockCategoryResponseItem.id }
            val categoryItems = filteredMap.values.toMutableSet()
            livestockIdBreedAndLivestockItem[liveStockCategoryResponseItem.id!!] = categoryItems
        }

    }

    fun getCountyFromCode(code: Int) {
        county = countiesMap[code]
    }



}