package com.example.shambadata.models


data class ScheduleItem(
    var animalId: String? = null,
    var scheduleActivityName: String? = null,
    var scheduleDate: String? = null,
    var scheduleId: String? = null
){
    var animalItem:AnimalItem? = null

}
