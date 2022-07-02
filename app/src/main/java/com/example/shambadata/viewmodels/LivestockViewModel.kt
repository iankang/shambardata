package com.example.shambadata.viewmodels

import androidx.lifecycle.ViewModel
import com.example.shambadata.data.DataWrangler

class LivestockViewModel(
     val dataWrangler: DataWrangler
) : ViewModel()