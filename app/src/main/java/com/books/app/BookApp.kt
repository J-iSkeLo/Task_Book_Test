package com.books.app

import android.app.Application
import com.books.app.di.serviceModule
import com.books.app.di.viewModelsModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class BookApp :Application() {

    companion object {
        lateinit var instance :BookApp
    }

    override fun onCreate() {
        super.onCreate()
        instance = this

        startKoin {
            androidContext(this@BookApp)
            modules(serviceModule, viewModelsModule)
        }
    }
}