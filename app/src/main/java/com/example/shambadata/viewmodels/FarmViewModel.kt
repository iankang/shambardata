package com.example.shambadata.viewmodels

import androidx.lifecycle.ViewModel
import com.example.shambadata.models.ShambaDataResponseItem
import com.example.shambadataapi.models.FarmsResponse
import com.example.shambadataapi.models.FarmsResponseItem

class FarmViewModel(val shambaDataJson: List<ShambaDataResponseItem>):ViewModel() {

    val farms = mutableListOf<ShambaDataResponseItem>()

    init {
        getFarms()
    }

    fun getFarms(){
        shambaDataJson.forEach { shambaDataResponseItem: ShambaDataResponseItem ->
                farms.add(shambaDataResponseItem)
        }
    }

}