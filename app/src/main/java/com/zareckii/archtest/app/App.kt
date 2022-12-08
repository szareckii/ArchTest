package com.zareckii.archtest.app

import android.app.Application
import com.zareckii.archtest.di.appModule
import com.zareckii.archtest.di.dataModule
import com.zareckii.archtest.di.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@App)
            modules(listOf(appModule, dataModule, domainModule))
        }
    }
}