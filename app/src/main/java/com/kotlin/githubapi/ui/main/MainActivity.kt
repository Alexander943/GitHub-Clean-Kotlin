package com.kotlin.githubapi.ui.main

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import com.kotlin.githubapi.R
import com.kotlin.githubapi.ui.base.BaseActivity
import com.kotlin.githubapi.ui.usersearch.UserSearchActivity

class MainActivity : BaseActivity() {

    override fun getLayoutResource(): Int = R.layout.main_activity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        findViewById<Button>(R.id.ma_btn_go_user_search).setOnClickListener {
            startActivity(Intent(this@MainActivity, UserSearchActivity::class.java))
        }
    }
}
