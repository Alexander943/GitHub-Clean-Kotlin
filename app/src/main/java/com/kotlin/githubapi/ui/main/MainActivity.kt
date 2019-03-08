package com.kotlin.githubapi.ui.main

import android.content.Intent
import android.os.Bundle
import com.kotlin.githubapi.R
import com.kotlin.githubapi.ui.base.BaseActivity
import com.kotlin.githubapi.ui.usersearch.UserSearchActivity
import kotlinx.android.synthetic.main.main_activity.*

class MainActivity : BaseActivity() {

    override fun getLayoutResource(): Int = R.layout.main_activity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        ma_btn_go_user_search.setOnClickListener {
            startActivity(Intent(this@MainActivity, UserSearchActivity::class.java))
        }
    }
}