package com.example.shambadataapi.models


import com.google.gson.annotations.SerializedName

data class County(
    @SerializedName("capital")
    var capital: String? = null,
    @SerializedName("code")
    var code: Int? = null,
    @SerializedName("name")
    var name: String? = null
)