package com.kotlin.githubapi.ui.usersearch

import android.os.Bundle
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.kotlin.githubapi.R
import com.kotlin.githubapi.ui.base.AppViewModelFactory
import com.kotlin.githubapi.ui.base.BaseActivity
import kotlinx.android.synthetic.main.user_search_activity.*
import javax.inject.Inject

class UserSearchActivity : BaseActivity() {

    private lateinit var adapter: UserSearchListAdapter
    private lateinit var viewModel: UserSearchViewModel

    @Inject
    lateinit var viewModelFactory: AppViewModelFactory

    override fun getLayoutResource(): Int = R.layout.user_search_activity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = UserSearchListAdapter(mutableListOf())

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(UserSearchViewModel::class.java)
        viewModel.users.observe(this, Observer { adapter.updateItems(it) })

        usa_search_view.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                viewModel.loadUsers(usa_search_view.query.toString())
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return true
            }
        })

        usa_recycler_view.adapter = adapter
    }
}
