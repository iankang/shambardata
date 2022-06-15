package com.example.shambadataapi.models


import com.google.gson.annotations.SerializedName

data class FarmsResponseItem(
    @SerializedName("areaInMetresSquared")
    var areaInMetresSquared: Int? = null,
    @SerializedName("county")
    var county: County? = null,
    @SerializedName("createdAt")
    var createdAt: String? = null,
    @SerializedName("farmName")
    var farmName: String? = null,
    @SerializedName("id")
    var id: Int? = null,
    @SerializedName("updatedAt")
    var updatedAt: String? = null,
    @SerializedName("user")
    var user: User? = null
)