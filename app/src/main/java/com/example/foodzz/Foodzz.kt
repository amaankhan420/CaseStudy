package com.example.foodzz

import android.app.Application
import android.util.Log
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class Foodzz : Application() {
    override fun onCreate() {
        super.onCreate()
        Log.d("Foodzz", "Application is injected with Hilt.")
    }
}