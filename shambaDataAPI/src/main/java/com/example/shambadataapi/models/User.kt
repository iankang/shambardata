package com.example.shambadataapi.models


import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("email")
    var email: String? = null,
    @SerializedName("id")
    var id: Int? = null,
    @SerializedName("isActive")
    var isActive: Boolean? = null,
    @SerializedName("isEmailVerified")
    var isEmailVerified: Boolean? = null,
    @SerializedName("password")
    var password: String? = null,
    @SerializedName("roles")
    var roles: List<Role>? = null,
    @SerializedName("username")
    var username: String? = null
)