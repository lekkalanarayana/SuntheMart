package com.example.sunthemart.Activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.sunthemart.R

class SplashActivty : AppCompatActivity() {
    public var mHandletr: Handler? =null
    private val SPLASH_DELAY= 3000 //3 seconds



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        mInitObjects()
        mInitWedgets()
    }

    private fun mInitWedgets() {
    }

    private fun mInitObjects() {
        mHandletr= Handler()
        mHandletr!!.postDelayed(mRunnable, SPLASH_DELAY.toLong())


    }
    internal val mRunnable: Runnable = Runnable {

        val intent = Intent(applicationContext, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }
}
