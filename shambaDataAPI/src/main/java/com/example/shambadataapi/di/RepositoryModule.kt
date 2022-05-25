package com.example.shambadataapi.di

import com.example.shambadataapi.repository.ShambaDataApi
import org.koin.dsl.module

val repositoryModule = module {
    single { provideGlobalShambaDataApiRepository()  }
}

fun provideGlobalShambaDataApiRepository(): ShambaDataApi {
    return ShambaDataApi()
}