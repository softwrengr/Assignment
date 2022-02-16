package com.gts.assignment.utils

import android.app.Application
import com.gts.assignment.R

class StringUtils(private val appContext: Application) {
    fun message() = appContext.getString(R.string.message)
}