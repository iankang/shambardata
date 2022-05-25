package com.example.shambadataapi.models


import com.google.gson.annotations.SerializedName

data class SignupResponse(
    @SerializedName("message")
    var message: String? = null
)