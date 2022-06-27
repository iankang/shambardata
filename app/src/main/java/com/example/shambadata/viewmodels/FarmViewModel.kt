package com.example.shambadata.viewmodels

import androidx.lifecycle.ViewModel
import com.example.shambadata.models.CountiesResponse
import com.example.shambadata.models.CountiesResponseItem
import com.example.shambadata.models.ShambaDataResponseItem
import com.example.shambadataapi.models.FarmsResponse
import com.example.shambadataapi.models.FarmsResponseItem

class FarmViewModel(
    val shambaDataJson: List<ShambaDataResponseItem>,
    val countyData: CountiesResponse
    ):ViewModel() {

    val farms = mutableListOf<ShambaDataResponseItem>()
    val locs = mutableMapOf<String,CountiesResponseItem>()

    init {
        getFarms()
        createLocationMap()
    }

    fun getFarms(){

        shambaDataJson.forEach { shambaDataResponseItem: ShambaDataResponseItem ->
                farms.add(shambaDataResponseItem)
        }
    }

    fun createLocationMap(){
        countyData?.forEach { countiesResponseItem ->
            locs.put(countiesResponseItem.code.toString(),countiesResponseItem)
        }
    }

    fun getCountyFromCountyCode(countyCode:String): CountiesResponseItem? {
        return locs[countyCode]
    }

}