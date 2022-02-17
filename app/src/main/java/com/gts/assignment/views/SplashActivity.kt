package com.gts.assignment.views

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.gts.assignment.base.BaseActivity
import com.gts.assignment.databinding.ActivitySplashBinding
import com.gts.assignment.utils.LocaleHelper
import com.gts.assignment.utils.MySharePreference
import com.gts.assignment.viewModels.MyViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.*

@AndroidEntryPoint
class SplashActivity : BaseActivity<ActivitySplashBinding>() {

    private val activityScope = CoroutineScope(Dispatchers.Main)
    private val viewModel: MyViewModel by viewModels()
    private lateinit var strMessage: String

    override fun getViewBinding(): ActivitySplashBinding {
        return ActivitySplashBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.lifecycleOwner = this
        supportActionBar?.hide()

        viewModel.getFirebaseData()
        activityScope.launch {
            delay(3000)
            loadMainActivity()
        }

    }


    private fun loadMainActivity() {

        val mySharePreference = MySharePreference.getInstance(this)
        strMessage = if (mySharePreference.getLanguage().equals("en", ignoreCase = true)) {
            viewModel.enMsg.value.toString()
        } else {
            viewModel.arMsg.value.toString()
        }

        val intent = Intent(this@SplashActivity, MainActivity::class.java).apply {
            putExtra("isSetBanner", viewModel.isShowBanner.value)
            putExtra("message", strMessage)
        }
        startActivity(intent)
        finish()
    }

    override fun onDestroy() {
        activityScope.cancel()
        super.onDestroy()
    }

}