package com.example.demokotlin

import android.app.Application
import com.example.demokotlin.manager.Contextor

class MainApp : Application() {

    override fun onCreate() {
        super.onCreate()

        Contextor.getInstance().init(baseContext)
    }

    override fun onTerminate() {
        super.onTerminate()
    }
}