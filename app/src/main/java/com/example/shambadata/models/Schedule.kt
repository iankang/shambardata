package com.example.shambadata.models


import com.google.gson.annotations.SerializedName

data class Schedule(
    @SerializedName("animal_id")
    var animalId: String? = null,
    @SerializedName("schedule_activity_name")
    var scheduleActivityName: String? = null,
    @SerializedName("schedule_date")
    var scheduleDate: String? = null,
    @SerializedName("schedule_id")
    var scheduleId: String? = null
)

fun Schedule.toScheduleItem():ScheduleItem{
    return ScheduleItem(
        animalId = animalId,
        scheduleActivityName = scheduleActivityName,
        scheduleDate = scheduleDate,
        scheduleId = scheduleId
    )
}