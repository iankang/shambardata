package com.example.shambadata.models


import com.google.gson.annotations.SerializedName

data class LiveStockCategoryResponseItem(
    @SerializedName("id")
    var id: Int? = null,
    @SerializedName("image")
    var image: String? = null,
    @SerializedName("species")
    var species: String? = null
)