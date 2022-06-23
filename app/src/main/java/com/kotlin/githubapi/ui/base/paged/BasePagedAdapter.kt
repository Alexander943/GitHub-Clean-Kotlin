package com.kotlin.githubapi.ui.base.paged

import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.AsyncDifferConfig
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

abstract class BasePagedAdapter<T : Any, VH : RecyclerView.ViewHolder> : PagedListAdapter<T, VH> {

    protected var pageState: PageState? = null
    private var isLoading: Boolean = false

    val isEmpty: Boolean?
        get() = itemCount <= 0

    constructor(diffCallback: DiffUtil.ItemCallback<T>) : super(diffCallback)

    constructor(config: AsyncDifferConfig<T>) : super(config)

    fun updatePageState(newPageState: PageState) {
        if (currentList == null || currentList!!.isEmpty()) return
        if (newPageState == PageState.LOADING) {
            isLoading = true
            notifyItemChanged(itemCount - 1)
        } else if (newPageState.pageLoadStatus != null) {
            when (newPageState.pageLoadStatus) {
                PageLoadStatus.RUNNING -> {
                    if (isLoading) return
                    isLoading = true
                    notifyItemInserted(itemCount)
                }
                PageLoadStatus.SUCCESS,
                PageLoadStatus.EMPTY,
                PageLoadStatus.FAILED -> {
                    isLoading = false
                    notifyItemRemoved(itemCount)
                }
                else -> error("Please specify all the cases.")
            }
        }
    }

    protected fun hasExtraRow(): Boolean = isLoading
}
