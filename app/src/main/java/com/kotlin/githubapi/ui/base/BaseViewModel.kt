package com.kotlin.githubapi.ui.base

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel : ViewModel() {

    protected val compositeDisposable = CompositeDisposable()

    val loading = SingleLiveEvent<Boolean>()
    val error = SingleLiveEvent<Throwable>()

    override fun onCleared() {
        compositeDisposable.clear()
    }

}