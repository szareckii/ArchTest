package com.zareckii.archtest.app

import android.app.Application
import com.zareckii.archtest.di.AppComponent
import com.zareckii.archtest.di.AppModule
import com.zareckii.archtest.di.DaggerAppComponent

class App : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent
            .builder()
            .appModule(AppModule(context = this))
            .build()
    }
}