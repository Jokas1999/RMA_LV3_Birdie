package com.example.lv3_zadatak

import android.app.Application

class Birdie: Application() {

    override fun onCreate() {
        super.onCreate()
        application = this
    }

    companion object{
        lateinit var application: Application
    }
}