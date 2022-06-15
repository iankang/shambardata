package com.example.shambadata.di

import com.example.shambadataapi.di.provideGlobalShambaDataApiRepository
import org.koin.dsl.module

val apiModule = module {
    single { provideGlobalShambaDataApiRepository() }
}