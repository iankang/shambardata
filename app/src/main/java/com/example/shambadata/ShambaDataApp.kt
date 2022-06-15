package com.example.shambadata

import android.app.Application
import com.example.shambadata.di.apiModule
import com.example.shambadata.di.viewModelModule
import com.example.shambadataapi.di.repositoryModule
import com.example.shambadataapi.di.shambaDataModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin
import org.koin.core.logger.Level

class ShambaDataApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(applicationContext)
            modules(
                listOf(
                    apiModule,
                    viewModelModule,
                    shambaDataModule,
                    repositoryModule
                )
            )
        }

    }
}