package com.gts.assignment.app

import android.app.Application
import android.content.Context
import androidx.appcompat.app.AppCompatDelegate
import com.gts.assignment.utils.LocaleHelper
import com.gts.assignment.utils.MyExtensions
import com.gts.assignment.utils.MyExtensions.isNight
import com.gts.assignment.utils.MyExtensions.setupDayNightMode
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        setupDayNightMode()
    }


    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(LocaleHelper.onAttach(base))
    }
}