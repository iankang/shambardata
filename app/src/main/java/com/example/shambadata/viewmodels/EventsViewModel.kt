package com.example.shambadata.viewmodels


import androidx.lifecycle.ViewModel
import com.example.shambadata.models.Animal
import com.example.shambadata.models.Schedule
import com.example.shambadata.models.ShambaDataResponseItem


class EventsViewModel(val shambaDataJson: List<ShambaDataResponseItem>) : ViewModel() {

    var scheduleList = mutableListOf<Schedule>()

    fun addSchedules(){
        shambaDataJson.forEach { shambaDataResponseItem: ShambaDataResponseItem ->
            shambaDataResponseItem.schedule?.forEach { schedule: Schedule ->
                scheduleList.add(schedule)
            }
        }

    }

    fun getAnimalFromId(animalId:String){
        shambaDataJson.forEach {shambaDataResponseItem: ShambaDataResponseItem ->
            shambaDataResponseItem.animals?.forEach { animal: Animal ->
                animal.animalId == animalId

            }
        }
    }
}