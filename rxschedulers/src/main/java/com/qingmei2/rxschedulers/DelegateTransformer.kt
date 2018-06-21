package com.qingmei2.rxschedulers

import io.reactivex.*

interface DelegateTransformer<T, R> : FlowableTransformer<T, R>,
        ObservableTransformer<T, R>,
        MaybeTransformer<T, R>,
        SingleTransformer<T, R>,
        CompletableTransformer