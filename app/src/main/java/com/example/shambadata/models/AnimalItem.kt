package com.example.shambadata.models

import com.example.shambadata.models.models_ui.FarmItem

data class AnimalItem(
    var animalId: String? = null,
    var animalNameOrTag: String? = null,
    var breed: String? = null,
    var dob: String? = null,
    var sex: String? = null,
    var farmId: String? = null
) {
    var livestockAndBreedItem: LivestockAndBreedItem? = null
    var farmItem: FarmItem? = null


    override fun toString(): String {
        return "AnimalItem(animalId=$animalId, animalNameOrTag=$animalNameOrTag, breed=$breed, dob=$dob, sex=$sex, farmId=$farmId, livestockAndBreedItem=$livestockAndBreedItem, farmItem=$farmItem)"
    }
}



