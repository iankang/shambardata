package com.example.shambadataapi.models

data class ShambaDataResponse<T>(
    var data: T? = null,
    var message :String= "fail",
    var isOk: Boolean = false,
    var httpStatus:Int = 0
)
