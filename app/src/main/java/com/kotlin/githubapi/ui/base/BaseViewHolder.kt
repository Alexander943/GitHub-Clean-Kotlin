package com.kotlin.githubapi.ui.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder(parent: ViewGroup, @LayoutRes resId: Int)
    : RecyclerView.ViewHolder(LayoutInflater.from(parent.context).inflate(resId, parent, false))