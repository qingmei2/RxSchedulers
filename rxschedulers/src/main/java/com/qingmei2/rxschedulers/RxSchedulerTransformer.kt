package com.qingmei2.rxschedulers

import io.reactivex.*
import org.reactivestreams.Publisher

interface IRxSchedulerTransformer<T, R> : FlowableTransformer<T, R>,
        ObservableTransformer<T, R>,
        MaybeTransformer<T, R>,
        SingleTransformer<T, R>,
        CompletableTransformer

class RxSchedulerTransformer<T> : IRxSchedulerTransformer<T, T> {

    override fun apply(upstream: Flowable<T>): Publisher<T> =
            upstream.subscribeOn(SchedulerProvider.io())
                    .observeOn(SchedulerProvider.ui())

    override fun apply(upstream: Observable<T>): ObservableSource<T> =
            upstream.subscribeOn(SchedulerProvider.io())
                    .observeOn(SchedulerProvider.ui())

    override fun apply(upstream: Maybe<T>): MaybeSource<T> =
            upstream.subscribeOn(SchedulerProvider.io())
                    .observeOn(SchedulerProvider.ui())

    override fun apply(upstream: Single<T>): SingleSource<T> =
            upstream.subscribeOn(SchedulerProvider.io())
                    .observeOn(SchedulerProvider.ui())

    override fun apply(upstream: Completable): CompletableSource =
            upstream.subscribeOn(SchedulerProvider.io())
                    .observeOn(SchedulerProvider.ui())
}
