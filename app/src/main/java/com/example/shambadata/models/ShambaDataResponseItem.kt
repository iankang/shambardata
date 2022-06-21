package com.example.shambadata.models


import com.google.gson.annotations.SerializedName

data class ShambaDataResponseItem(
    @SerializedName("animals")
    var animals: List<Animal>? = null,
    @SerializedName("areaInMetresSquared")
    var areaInMetresSquared: String? = null,
    @SerializedName("county_code")
    var countyCode: String? = null,
    @SerializedName("farm_id")
    var farmId: String? = null,
    @SerializedName("farmName")
    var farmName: String? = null,
    @SerializedName("farm_profile")
    var farmProfile: String? = null,
    @SerializedName("latitude")
    var latitude: String? = null,
    @SerializedName("longitude")
    var longitude: String? = null,
    @SerializedName("schedule")
    var schedule: List<Schedule>? = null
)