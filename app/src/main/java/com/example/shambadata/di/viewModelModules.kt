package com.example.shambadata.di


import com.example.shambadata.viewmodels.EventsViewModel
import com.example.shambadata.viewmodels.FarmViewModel
import com.example.shambadata.viewmodels.LivestockViewModel
import com.example.shambadata.viewmodels.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val viewModelModule = module {
    viewModel {
        LoginViewModel(get())
    }
    viewModel {
        EventsViewModel(get())
    }
    viewModel {
        FarmViewModel(get())
    }
    viewModel {
        LivestockViewModel(get())
    }
}