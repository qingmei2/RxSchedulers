package com.qingmei2.rxschedulers

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

interface ISchedulerProvider {

    fun ui(): Scheduler

    fun io(): Scheduler
}

/**
 * The [SchedulerProvider] is wrapper of the schedulers, it is easily for unit testing.
 */
object SchedulerProvider : ISchedulerProvider {

    private var ioSchedulerProvider: () -> Scheduler = {
        Schedulers.io()
    }

    private var uiSchedulerProvider: () -> Scheduler = {
        AndroidSchedulers.mainThread()
    }

    override fun ui(): Scheduler = uiSchedulerProvider()

    override fun io(): Scheduler = ioSchedulerProvider()

    fun reset(ioScheduler: () -> Scheduler = ioSchedulerProvider,
              uiScheduler: () -> Scheduler = uiSchedulerProvider): SchedulerProvider {
        ioSchedulerProvider = ioScheduler
        uiSchedulerProvider = uiScheduler
        return this
    }
}