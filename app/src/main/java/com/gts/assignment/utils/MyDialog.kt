package com.gts.assignment.utils

import android.app.Activity
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AlertDialog
import com.gts.assignment.views.SplashActivity

class MyDialog {

    companion object {

        fun setLanguage(context: Activity) {
            var mySharePreference: MySharePreference = MySharePreference.getInstance(context)

            val language = arrayOf("English", "العربية")
            val checkedItem = if (mySharePreference.getLanguage().equals("en", ignoreCase = true)) 0 else 1
            val builder = AlertDialog.Builder(context)
            builder.setTitle("Select Language")
            builder.setSingleChoiceItems(language, checkedItem) { dialog: DialogInterface, item: Int ->
                if ("English".equals(language[item], ignoreCase = true)) {
                    mySharePreference.setLanguage("en")
                    LocaleHelper.setLocale(context, mySharePreference.getLanguage())

                } else {
                    mySharePreference.setLanguage("ar")
                    LocaleHelper.setLocale(context, mySharePreference.getLanguage())
                }
                val intent = Intent(context, SplashActivity::class.java)
                context.finishAffinity()
                context.startActivity(intent)
                dialog.dismiss()
            }
            val alert = builder.create()
            alert.show()
        }

    }


}