package com.gts.assignment.utils


import android.content.Context
import android.content.res.Configuration
import android.content.res.Resources
import android.os.Build
import android.os.LocaleList
import java.util.*

class LocaleHelper {

    companion object {

        fun setLocale(c: Context, language: String?): Context {
            val locale = Locale(language)
            Locale.setDefault(locale)

            var context = c

            val resources: Resources = context.resources
            val configuration: Configuration = resources.configuration
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                val localeList = LocaleList(locale)
                LocaleList.setDefault(localeList)
                configuration.setLocales(localeList)
            } else {
                configuration.locale = locale
            }
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N_MR1) {
                context = context.createConfigurationContext(configuration)
            } else {
                resources.updateConfiguration(configuration, resources.displayMetrics)
            }
            return context
        }


        fun onAttach(context: Context): Context {
            return setLocale(context, MySharePreference.getInstance(context).getLanguage())
        }

    }
}