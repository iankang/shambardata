package com.example.shambadata.viewmodels

import androidx.lifecycle.ViewModel
import com.example.shambadata.models.*

class LivestockViewModel(
    val shambaDataJson: List<ShambaDataResponseItem>,
    val liveStockBreedResponse: LiveStockBreedResponse,
    val livestockCategory: LiveStockCategoryResponse
) : ViewModel() {

    val animalItems = mutableListOf<AnimalItem>()
    val breedMap = mutableMapOf<Int,LivestockAndBreedItem>()


    init {
        getAllAnimals()
        mapAllBreeds()
    }

    private fun getAllAnimals() {
        shambaDataJson.forEach { shambaDataResponseItem: ShambaDataResponseItem ->
            shambaDataResponseItem.animals?.forEach { animal: Animal ->
                var animalItem = animal.toAnimalItem()
                animalItem.farmId = shambaDataResponseItem.farmId
                animalItems.add(animalItem)
            }
        }
    }

    private fun mapAllBreeds() {
        liveStockBreedResponse.forEach { liveStockBreedResponseItem ->
            breedMap[liveStockBreedResponseItem.id!!] = liveStockBreedResponseItem.toLivestockAndBreed()
        }
    }

}