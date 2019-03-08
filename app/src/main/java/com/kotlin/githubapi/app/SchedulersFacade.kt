package com.kotlin.githubapi.app

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

object SchedulersFacade {

    fun io(): Scheduler = Schedulers.io()

    fun computation(): Scheduler = Schedulers.computation()

    fun ui(): Scheduler = AndroidSchedulers.mainThread()

    fun single(): Scheduler = Schedulers.single()
}