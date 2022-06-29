package com.example.shambadata.models

import com.google.gson.annotations.SerializedName

data class AnimalItem(
    var animalId: String? = null,
    var animalNameOrTag: String? = null,
    var breed: String? = null,
    var dob: String? = null,
    var sex: String? = null,
    var farmId:String? = null
)
