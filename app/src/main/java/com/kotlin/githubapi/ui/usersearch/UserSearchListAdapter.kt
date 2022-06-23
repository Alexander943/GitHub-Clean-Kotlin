package com.kotlin.githubapi.ui.usersearch

import android.view.ViewGroup
import android.widget.TextView
import com.bumptech.glide.Glide
import com.kotlin.githubapi.R
import com.kotlin.githubapi.data.user.response.User
import com.kotlin.githubapi.ui.base.BaseListAdapter
import com.kotlin.githubapi.ui.base.BaseViewHolder

class UserSearchListAdapter(
        items: MutableList<User?>
) : BaseListAdapter<User?, UserSearchListAdapter.UserViewHolder>(items) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(parent)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)
        holder.bindView(getItem(holder.adapterPosition))
    }

    class UserViewHolder(parent: ViewGroup) : BaseViewHolder(parent, R.layout.user_list_item) {

        fun bindView(user: User?) = with(itemView) {
            findViewById<TextView>(R.id.uli_text_username).text = user?.login ?: ""

            Glide.with(context)
                    .load(user?.avatarUrl)
                    .into(findViewById(R.id.uli_image_avatar))
        }
    }
}
