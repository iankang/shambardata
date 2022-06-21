package com.example.shambadata.di

import android.content.Context
import com.example.shambadata.models.ShambaDataResponseItem
import com.example.shambadata.utils.Utils
import com.example.shambadataapi.di.provideGlobalShambaDataApiRepository
import org.koin.dsl.module

val apiModule = module {
    single { provideGlobalShambaDataApiRepository() }
    single { provideShambaDataJson(get()) }
}

fun provideShambaDataJson(context: Context):MutableList<ShambaDataResponseItem>{
    return Utils.getJsonFromAssets(context, "shamba_data.json")
}