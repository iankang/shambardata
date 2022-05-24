package com.example.shambadataapi

import android.app.Application
import org.koin.core.context.GlobalContext.startKoin

class ShambaDataApi: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin{

        }
    }
}