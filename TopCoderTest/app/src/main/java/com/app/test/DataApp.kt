package com.app.test

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@HiltAndroidApp
class DataApp: Application() {

    override fun onCreate() {
        super.onCreate()
    }
}