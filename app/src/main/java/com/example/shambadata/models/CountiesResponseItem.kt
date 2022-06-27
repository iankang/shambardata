package com.example.shambadata.models


import com.google.gson.annotations.SerializedName

data class CountiesResponseItem(
    @SerializedName("capital")
    var capital: String? = null,
    @SerializedName("code")
    var code: Int? = null,
    @SerializedName("name")
    var name: String? = null
)