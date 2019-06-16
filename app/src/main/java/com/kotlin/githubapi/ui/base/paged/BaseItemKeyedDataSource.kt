package com.kotlin.githubapi.ui.base.paged

import androidx.lifecycle.MutableLiveData
import androidx.paging.ItemKeyedDataSource
import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Action
import io.reactivex.schedulers.Schedulers
import timber.log.Timber

abstract class BaseItemKeyedDataSource<Key, Value> : ItemKeyedDataSource<Key, Value>() {

    protected var isCanLoadMore: Boolean = true

    val pageState = MutableLiveData<PageState>()
    val initialPageState = MutableLiveData<PageState>()

    private var retryCompletable: Completable? = null
    private var startCompletable: Completable? = null
    private var loadAfterCompletable: Completable? = null

    fun retry(compositeDisposable: CompositeDisposable) {
        if (retryCompletable == null) return
        compositeDisposable.add(retryCompletable!!
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({

                }, { Timber.e(it) })
        )
    }

    fun start(compositeDisposable: CompositeDisposable) {
        if (startCompletable == null) return
        compositeDisposable.add(startCompletable!!
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({

                }, { Timber.e(it) })
        )
    }

    protected fun setRetry(action: Action?) {
        retryCompletable = if (action != null) Completable.fromAction(action) else null
    }

    protected fun setStart(action: Action?) {
        startCompletable = if (action != null) Completable.fromAction(action) else null
    }

    protected fun setLoadAfterCompletable(action: Action?) {
        this.loadAfterCompletable = if (action != null) Completable.fromAction(action) else null
    }

    protected fun cleanupState() {
        initialPageState.value = null
        pageState.value = null
    }
}
