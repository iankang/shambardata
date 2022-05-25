package com.example.shambadataapi.models.requests


import com.google.gson.annotations.SerializedName

data class SignUpRequest(
    @SerializedName("confirm_password")
    var confirmPassword: String? = null,
    @SerializedName("email")
    var email: String? = null,
    @SerializedName("first_name")
    var firstName: String? = null,
    @SerializedName("is_Admin")
    var isAdmin: Boolean? = false,
    @SerializedName("is_Moderator")
    var isModerator: Boolean? = false,
    @SerializedName("last_name")
    var lastName: String? = null,
    @SerializedName("password")
    var password: String? = null,
    @SerializedName("username")
    var username: String? = null
)