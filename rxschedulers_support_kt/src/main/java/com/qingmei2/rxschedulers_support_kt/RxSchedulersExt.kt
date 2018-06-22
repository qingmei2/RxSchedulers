package com.qingmei2.rxschedulers_support_kt

import com.qingmei2.rxschedulers.RxSchedulerProvider
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

/** --------- observerOn extensions --------- **/

fun <T> Observable<T>.observerOnUi(): Observable<T> =
        observeOn(RxSchedulerProvider.INSTANCE.ui())

fun <T> Flowable<T>.observerOnUi(): Flowable<T> =
        observeOn(RxSchedulerProvider.INSTANCE.ui())

fun <T> Single<T>.observerOnUi(): Single<T> =
        observeOn(RxSchedulerProvider.INSTANCE.ui())

fun <T> Maybe<T>.observerOnUi(): Maybe<T> =
        observeOn(RxSchedulerProvider.INSTANCE.ui())

fun Completable.observerOnUi(): Completable =
        observeOn(RxSchedulerProvider.INSTANCE.ui())

fun <T> Observable<T>.observerOnIo(): Observable<T> =
        observeOn(RxSchedulerProvider.INSTANCE.io())

fun <T> Flowable<T>.observerOnIo(): Flowable<T> =
        observeOn(RxSchedulerProvider.INSTANCE.io())

fun <T> Single<T>.observerOnIo(): Single<T> =
        observeOn(RxSchedulerProvider.INSTANCE.io())

fun <T> Maybe<T>.observerOnIo(): Maybe<T> =
        observeOn(RxSchedulerProvider.INSTANCE.io())

fun Completable.observerOnIo(): Completable =
        observeOn(RxSchedulerProvider.INSTANCE.io())

/** --------- subscribeOn extensions --------- **/

fun <T> Observable<T>.subscribeOnUi(): Observable<T> =
        subscribeOn(RxSchedulerProvider.INSTANCE.ui())

fun <T> Flowable<T>.subscribeOnUi(): Flowable<T> =
        subscribeOn(RxSchedulerProvider.INSTANCE.ui())

fun <T> Single<T>.subscribeOnUi(): Single<T> =
        subscribeOn(RxSchedulerProvider.INSTANCE.ui())

fun <T> Maybe<T>.subscribeOnUi(): Maybe<T> =
        subscribeOn(RxSchedulerProvider.INSTANCE.ui())

fun Completable.subscribeOnUi(): Completable =
        subscribeOn(RxSchedulerProvider.INSTANCE.ui())

fun <T> Observable<T>.subscribeOnIo(): Observable<T> =
        subscribeOn(RxSchedulerProvider.INSTANCE.io())

fun <T> Flowable<T>.subscribeOnIo(): Flowable<T> =
        subscribeOn(RxSchedulerProvider.INSTANCE.io())

fun <T> Single<T>.subscribeOnIo(): Single<T> =
        subscribeOn(RxSchedulerProvider.INSTANCE.io())

fun <T> Maybe<T>.subscribeOnIo(): Maybe<T> =
        subscribeOn(RxSchedulerProvider.INSTANCE.io())

fun Completable.subscribeOnIo(): Completable =
        subscribeOn(RxSchedulerProvider.INSTANCE.io())