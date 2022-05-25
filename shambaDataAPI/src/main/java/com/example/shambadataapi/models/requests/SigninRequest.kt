package com.example.shambadataapi.models.requests

data class SigninRequest(
    val identifier: String,
    val password: String
)