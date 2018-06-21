package com.qingmei2.rxschedulers

import io.reactivex.*
import org.reactivestreams.Publisher

/**
 * The delegate of different reactive types.
 */
class RxSchedulerTransformer<T>(
        private val schedulerProvider: SchedulerProvider = RxSchedulerProvider.INSTANCE
) : DelegateTransformer<T, T> {

    override fun apply(upstream: Flowable<T>): Publisher<T> =
            upstream.subscribeOn(schedulerProvider.io())
                    .observeOn(schedulerProvider.ui())

    override fun apply(upstream: Observable<T>): ObservableSource<T> =
            upstream.subscribeOn(schedulerProvider.io())
                    .observeOn(schedulerProvider.ui())

    override fun apply(upstream: Maybe<T>): MaybeSource<T> =
            upstream.subscribeOn(schedulerProvider.io())
                    .observeOn(schedulerProvider.ui())

    override fun apply(upstream: Single<T>): SingleSource<T> =
            upstream.subscribeOn(schedulerProvider.io())
                    .observeOn(schedulerProvider.ui())

    override fun apply(upstream: Completable): CompletableSource =
            upstream.subscribeOn(schedulerProvider.io())
                    .observeOn(schedulerProvider.ui())
}
