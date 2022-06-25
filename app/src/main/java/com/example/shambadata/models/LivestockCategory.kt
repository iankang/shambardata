package com.example.shambadata.models


import com.google.gson.annotations.SerializedName

data class LivestockCategory(
    @SerializedName("id")
    var id: Int? = null,
    @SerializedName("species")
    var species: String? = null
)