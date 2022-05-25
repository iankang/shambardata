package com.example.shambadataapi.models


import com.google.gson.annotations.SerializedName

data class UsernameAvailabilityResponse(
    @SerializedName("is_available")
    var isAvailable: Boolean? = null
)