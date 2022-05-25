package com.example.shambadataapi.models


import com.google.gson.annotations.SerializedName

data class Role(
    @SerializedName("id")
    var id: Int? = null,
    @SerializedName("name")
    var name: String? = null
)