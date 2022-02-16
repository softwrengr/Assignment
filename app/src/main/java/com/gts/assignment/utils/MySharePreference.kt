package com.gts.assignment.utils

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager

class MySharePreference(context: Context?) {

    private var instance: MySharePreference? = null
    private var pref: SharedPreferences? = null


    init {
        pref = if (context != null) {
            PreferenceManager.getDefaultSharedPreferences(context)
        } else {
            PreferenceManager.getDefaultSharedPreferences(context)
        }
    }

    companion object {

        fun getInstance(context: Context?): MySharePreference {
            var instance: MySharePreference? = null
            val pref: SharedPreferences? = null

            if (instance == null || pref == null) {
                instance = MySharePreference(context)
            }
            return instance
        }


    }


    fun getLanguage(): String? {
        return pref?.getString("appLanguage", "en")
    }

    fun setLanguage(value: String?) {
        pref?.edit()?.putString("appLanguage", value)?.apply()
    }

}