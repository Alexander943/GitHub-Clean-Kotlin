package com.kotlin.githubapi.ui.splash

import android.content.Intent
import android.os.Bundle
import com.kotlin.githubapi.R
import com.kotlin.githubapi.ui.base.BaseActivity
import com.kotlin.githubapi.ui.main.MainActivity

class SplashActivity : BaseActivity() {

    override fun getLayoutResource(): Int = R.layout.splash_activity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startActivity(Intent(this@SplashActivity, MainActivity::class.java))
        finishAffinity()
    }
}