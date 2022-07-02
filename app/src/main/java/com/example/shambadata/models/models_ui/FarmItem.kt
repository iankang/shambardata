package com.example.shambadata.models.models_ui

import com.example.shambadata.models.AnimalItem
import com.example.shambadata.models.Schedule

data class FarmItem(
    var areaInMetresSquared: String? = null,
    var countyCode: String? = null,
    var farmId: String? = null,
    var farmName: String? = null,
    var farmProfile: String? = null,
    var latitude: String? = null,
    var longitude: String? = null,
) {
    var animals: List<AnimalItem>? = null
    var schedule: List<Schedule>? = null
    override fun toString(): String {
        return "FarmItem(areaInMetresSquared=$areaInMetresSquared, countyCode=$countyCode, farmId=$farmId, farmName=$farmName, farmProfile=$farmProfile, latitude=$latitude, longitude=$longitude, animals=$animals, schedule=$schedule)"
    }
}
