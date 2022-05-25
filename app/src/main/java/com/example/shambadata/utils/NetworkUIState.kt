package com.example.shambadata.utils

data class NetworkUIState<T>(
    var response: T? = null,
    var isSuccessful: Boolean = false,
    var throwError: Boolean = false,
    var loading: Boolean = true,
    var error: String? = null,
)
