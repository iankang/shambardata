package com.example.shambadata.viewmodels

import androidx.lifecycle.ViewModel
import com.example.shambadata.models.ShambaDataResponseItem

class FarmViewModel(val shambaDataJson: List<ShambaDataResponseItem>):ViewModel() {
}