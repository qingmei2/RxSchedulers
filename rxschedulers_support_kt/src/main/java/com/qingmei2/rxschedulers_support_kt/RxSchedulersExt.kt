package com.qingmei2.rxschedulers_support_kt

import com.qingmei2.rxschedulers.RxSchedulerTransformer
import io.reactivex.*

fun <T> Observable<T>.switchThread(): Observable<T> =
        compose(RxSchedulerTransformer())

fun <T> Flowable<T>.switchThread(): Flowable<T> =
        compose(RxSchedulerTransformer())

fun <T> Single<T>.switchThread(): Single<T> =
        compose(RxSchedulerTransformer())

fun <T> Maybe<T>.switchThread(): Maybe<T> =
        compose(RxSchedulerTransformer())

fun Completable.switchThread(): Completable =
        compose(RxSchedulerTransformer<Any>())