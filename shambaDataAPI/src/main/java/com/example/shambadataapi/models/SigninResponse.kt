package com.example.shambadataapi.models


import com.google.gson.annotations.SerializedName

data class SigninResponse(
    @SerializedName("access_token")
    var accessToken: String? = null,
    @SerializedName("token_type")
    var tokenType: String? = null,
    @SerializedName("user")
    var user: User? = null
)