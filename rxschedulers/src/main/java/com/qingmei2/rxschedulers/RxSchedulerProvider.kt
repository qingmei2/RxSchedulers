package com.qingmei2.rxschedulers

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * The [RxSchedulerProvider] is wrapper of the schedulers, it is easily for unit testing.
 */
class RxSchedulerProvider : SchedulerProvider {

    private var ioSchedulerProvider: () -> Scheduler = {
        Schedulers.io()
    }

    private var uiSchedulerProvider: () -> Scheduler = {
        AndroidSchedulers.mainThread()
    }

    override fun ui(): Scheduler = uiSchedulerProvider()

    override fun io(): Scheduler = ioSchedulerProvider()

    companion object {

        val INSTANCE: RxSchedulerProvider = RxSchedulerProvider()

        fun reset(ioScheduler: () -> Scheduler = INSTANCE.ioSchedulerProvider,
                  uiScheduler: () -> Scheduler = INSTANCE.uiSchedulerProvider): RxSchedulerProvider {
            INSTANCE.ioSchedulerProvider = ioScheduler
            INSTANCE.uiSchedulerProvider = uiScheduler
            return INSTANCE
        }
    }
}