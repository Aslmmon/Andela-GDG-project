package com.example.pluralsightcourse

import android.app.Application
import android.content.Context
import com.example.pluralsightcourse.common.di.networkModule
import com.example.pluralsightcourse.common.di.repositoriesModule
import com.example.pluralsightcourse.common.di.sharedPref
import com.example.pluralsightcourse.common.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class PluralSightApp : Application() {

    companion object {
        lateinit var context: Context
        fun getAppContext(): Context {
            return context
        }
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
        startKoin {
            androidContext(this@PluralSightApp)
            androidLogger()
            modules(listOf(viewModelModule, networkModule, repositoriesModule, sharedPref))
        }
    }
}
