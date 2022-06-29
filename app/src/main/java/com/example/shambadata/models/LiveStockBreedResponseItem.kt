package com.example.shambadata.models


import com.google.gson.annotations.SerializedName

data class LiveStockBreedResponseItem(
    @SerializedName("breed")
    var breed: String? = null,
    @SerializedName("id")
    var id: Int? = null,
    @SerializedName("livestockCategory")
    var livestockCategory: LivestockCategory? = null
)

fun LiveStockBreedResponseItem.toLivestockAndBreed() : LivestockAndBreedItem {
    return  LivestockAndBreedItem(
        breed = breed,
        breedId = id,
        categoryId = livestockCategory?.id,
        species = livestockCategory?.species
    )
}