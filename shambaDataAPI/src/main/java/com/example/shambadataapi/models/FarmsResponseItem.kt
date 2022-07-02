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

data class FarmResponseDTO(
    var areaInMetresSquared: Int? = null,
    var county: County? = null,
    var createdAt: String? = null,
    var farmName: String? = null,
    var id: Int? = null,
    var updatedAt: String? = null,
    var user: User? = null
){

}