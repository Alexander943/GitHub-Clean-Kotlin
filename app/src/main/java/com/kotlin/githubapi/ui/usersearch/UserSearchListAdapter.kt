package com.kotlin.githubapi.ui.usersearch

import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.kotlin.githubapi.R
import com.kotlin.githubapi.data.user.response.User
import com.kotlin.githubapi.ui.base.BaseListAdapter
import com.kotlin.githubapi.ui.base.BaseViewHolder
import kotlinx.android.synthetic.main.user_list_item.view.*

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
            uli_text_username.text = user?.login ?: ""

            Glide.with(context)
                    .load(user?.avatarUrl)
                    .into(uli_image_avatar)
        }
    }
}