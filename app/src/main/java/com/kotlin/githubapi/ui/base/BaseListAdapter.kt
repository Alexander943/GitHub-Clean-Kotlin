package com.kotlin.githubapi.ui.base

import androidx.recyclerview.widget.RecyclerView

abstract class BaseListAdapter<T, VH : RecyclerView.ViewHolder> : RecyclerView.Adapter<VH> {

    private var items: MutableList<T>? = null

    private var onItemClickListener: OnItemClickListener? = null
    private var onItemLongClickListener: OnItemLongClickListener? = null

    interface OnItemClickListener {

        fun onItemClick(position: Int)
    }

    interface OnItemLongClickListener {

        fun onItemLongClick(position: Int)
    }

    constructor(items: MutableList<T>) {
        this.items = items
    }

    constructor(items: MutableList<T>,
                onItemClickListener: OnItemClickListener) {
        this.items = items
        this.onItemClickListener = onItemClickListener
    }

    constructor(items: MutableList<T>,
                onItemLongClickListener: OnItemLongClickListener) {
        this.items = items
        this.onItemLongClickListener = onItemLongClickListener
    }

    constructor(items: MutableList<T>,
                onItemClickListener: OnItemClickListener,
                onItemLongClickListener: OnItemLongClickListener) {
        this.items = items
        this.onItemClickListener = onItemClickListener
        this.onItemLongClickListener = onItemLongClickListener
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.itemView.setOnClickListener {
            onItemClickListener?.onItemClick(holder.adapterPosition)
        }

        holder.itemView.setOnLongClickListener {
            onItemLongClickListener?.onItemLongClick(holder.adapterPosition)
            false
        }
    }

    override fun getItemCount(): Int {
        return items?.size ?: 0
    }


    open fun getItem(position: Int): T? {
        return this.items?.get(position)
    }

    open fun getItems(): MutableList<T>? {
        return this.items
    }

    open fun setItems(items: MutableList<T>) {
        this.items = items
        notifyDataSetChanged()
    }

    open fun addItem(item: T, position: Int) {
        this.items?.add(position, item)
        notifyDataSetChanged()
    }

    open fun deleteItem(position: Int) {
        items?.removeAt(position)
        notifyDataSetChanged()
    }

    open fun updateItem(item: T, position: Int) {
        this.items?.set(position, item)
        notifyDataSetChanged()
    }

    open fun updateItems(items: Collection<T>) {
        this.items = items.toMutableList()
        notifyDataSetChanged()
    }

    open fun addItems(items: MutableList<T>) {
        if (this.items != null) {
            this.items!!.addAll(items)
        } else {
            this.items = items
        }
        notifyDataSetChanged()
    }

    fun clearItems() {
        this.items?.clear()
        notifyDataSetChanged()
    }
}