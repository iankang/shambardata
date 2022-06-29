package com.example.shambadata.models


import com.google.gson.annotations.SerializedName

data class Animal(
    @SerializedName("animal_id")
    var animalId: String? = null,
    @SerializedName("animal_name_or_tag")
    var animalNameOrTag: String? = null,
    @SerializedName("breed")
    var breed: String? = null,
    @SerializedName("dob")
    var dob: String? = null,
    @SerializedName("sex")
    var sex: String? = null
)


fun Animal.toAnimalItem():AnimalItem {
    return AnimalItem(
        animalId = animalId,
        animalNameOrTag = animalNameOrTag,
        dob = dob,
        sex = sex
    )
}