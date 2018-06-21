## RxSchedulers

### How to use it

**In Kotlin:**

```kotlin
Observable
        .just(0)
        .delay(5, TimeUnit.SECONDS)
        .switchThread()         // the extension for kotlin
        .subscribe({
            Toast.makeText(this, "onNext: Int = $it", Toast.LENGTH_SHORT).show()
        })
```

**In Java:**

```Java
Observable
        .just(0)
        .delay(5, TimeUnit.SECONDS)
        .compose(new RxSchedulerTransformer())
        .subscribe()
```

### RxSchedulerTransformer

RxSchedulerTransformer is a proxy for different Reactive Transformer,So the Developer do not need to implement different **Transformers** based on different types.
:

```kotlin
interface IRxSchedulerTransformer<T, R> : FlowableTransformer<T, R>,
        ObservableTransformer<T, R>,
        MaybeTransformer<T, R>,
        SingleTransformer<T, R>,
        CompletableTransformer
```

License
-------

    The RxSchedulers：MIT License

    Copyright (c) 2018 qingmei2

    Permission is hereby granted, free of charge, to any person obtaining a copy
    of this software and associated documentation files (the "Software"), to deal
    in the Software without restriction, including without limitation the rights
    to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
    copies of the Software, and to permit persons to whom the Software is
    furnished to do so, subject to the following conditions:

    The above copyright notice and this permission notice shall be included in all
    copies or substantial portions of the Software.

    THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
    IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
    FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
    AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
    LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
    OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
    SOFTWARE.