package com.gts.assignment.utils

import android.content.Context
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatDelegate

object MyExtensions {

    //we can set ui mode as per day and night time automatically
    fun isNight(): Boolean {
        return false
    }

    fun setupDayNightMode() {
        // Get UI mode and set
        val mode = if (isNight()) {
            AppCompatDelegate.MODE_NIGHT_YES
        } else {
            AppCompatDelegate.MODE_NIGHT_NO
        }

        AppCompatDelegate.setDefaultNightMode(mode)
    }

    fun changeUIMode(context: Context) {
        val mode = if ((context.resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK) == Configuration.UI_MODE_NIGHT_NO) {
            AppCompatDelegate.MODE_NIGHT_YES
        } else {
            AppCompatDelegate.MODE_NIGHT_AUTO_BATTERY
        }

        AppCompatDelegate.setDefaultNightMode(mode)
        true
    }
}