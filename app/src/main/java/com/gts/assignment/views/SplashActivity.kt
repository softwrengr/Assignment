package com.gts.assignment.views

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import com.gts.assignment.R
import com.gts.assignment.base.BaseActivity
import com.gts.assignment.databinding.ActivitySplashBinding
import com.gts.assignment.utils.LocaleHelper
import com.gts.assignment.utils.MySharePreference
import com.gts.assignment.viewModels.SplashViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.*

@AndroidEntryPoint
class SplashActivity : BaseActivity<ActivitySplashBinding>() {

    private val activityScope = CoroutineScope(Dispatchers.Main)
    private val viewModel: SplashViewModel by viewModels()
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
        if (mySharePreference.getLanguage().equals("en", ignoreCase = true)) {
            strMessage = viewModel.enMsg.value.toString()
        } else {
            strMessage = viewModel.arMsg.value.toString()
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

    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(LocaleHelper.onAttach(newBase!!))
    }

}