package com.kotlin.githubapi.ui.base.paged

class PageState {

    var pageLoadStatus: PageLoadStatus? = null
        private set
    var message: String? = null

    private constructor(pageLoadStatus: PageLoadStatus, message: String) {
        this.pageLoadStatus = pageLoadStatus
        this.message = message
    }

    private constructor(pageLoadStatus: PageLoadStatus) {
        this.pageLoadStatus = pageLoadStatus
    }

    companion object {

        var LOADED = PageState(PageLoadStatus.SUCCESS)
        var LOADING = PageState(PageLoadStatus.RUNNING)
        var EMPTY = PageState(PageLoadStatus.EMPTY)

        fun error(message: String?): PageState {
            return PageState(PageLoadStatus.FAILED, message ?: "unknown error")
        }
    }
}
