package com.kotlin.githubapi.app.extension

import com.kotlin.githubapi.app.SchedulersFacade
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single

// IO to MAIN
fun <T> Observable<T>.threadManageIoToUi(): Observable<T> =
        this.subscribeOn(SchedulersFacade.io())
                .observeOn(SchedulersFacade.ui())

fun <T> Flowable<T>.threadManageIoToUi(): Flowable<T> =
        this.subscribeOn(SchedulersFacade.io())
                .observeOn(SchedulersFacade.ui())

fun <T> Single<T>.threadManageIoToUi(): Single<T> =
        this.subscribeOn(SchedulersFacade.io())
                .observeOn(SchedulersFacade.ui())


// COMPUTATION to MAIN
fun <T> Observable<T>.threadManageComputationToUi(): Observable<T> =
        this.subscribeOn(SchedulersFacade.computation())
                .observeOn(SchedulersFacade.ui())

fun <T> Flowable<T>.threadManageComputationToUi(): Flowable<T> =
        this.subscribeOn(SchedulersFacade.computation())
                .observeOn(SchedulersFacade.ui())

fun <T> Single<T>.threadManageComputationToUi(): Single<T> =
        this.subscribeOn(SchedulersFacade.computation())
                .observeOn(SchedulersFacade.ui())

