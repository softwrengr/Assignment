package com.gts.assignment.views

import android.content.Context
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.gts.assignment.R
import com.gts.assignment.base.BaseActivity
import com.gts.assignment.databinding.ActivityMainBinding
import com.gts.assignment.utils.LocaleHelper
import com.gts.assignment.utils.MyDialog
import com.gts.assignment.utils.MyExtensions.changeUIMode
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {

    private var isSetBanner: Boolean = false
    private var message: String = ""


    override fun getViewBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        isSetBanner = intent.extras?.getBoolean("isSetBanner") as Boolean
        message = intent.extras?.getString("message") as String

        binding.tvMessage.text = message
        if (isSetBanner) {
            binding.ivBanner.visibility = View.VISIBLE
        } else {
            binding.ivBanner.visibility = View.GONE
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.actionbar_menus, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_language -> MyDialog.setLanguage(this)
            R.id.action_mode -> changeUIMode(this)
        }
        return super.onOptionsItemSelected(item)
    }


    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(LocaleHelper.onAttach(newBase!!))
    }

}

