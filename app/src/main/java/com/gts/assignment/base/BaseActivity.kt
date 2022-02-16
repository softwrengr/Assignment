package com.gts.assignment.base

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding


abstract class BaseActivity<VB : ViewBinding> : AppCompatActivity() {

    lateinit var binding: VB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = getViewBinding()
        setContentView(binding.root)

    }

    abstract fun getViewBinding(): VB


    public override fun onResume() {
        super.onResume()
    }

    public override fun onPause() {
        super.onPause()
    }


    fun showToast(context: Context, message: String?) {
        Toast.makeText(context, "" + message, Toast.LENGTH_SHORT).show()
    }


    fun showLog(key: String, value: String) {
        Log.d(key, value)
    }

}