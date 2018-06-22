# RxSchedulers

[ ![Download](https://api.bintray.com/packages/mq2553299/maven/rxschedulers_support_kt/images/download.svg) ](https://bintray.com/mq2553299/maven/rxschedulers_support_kt/_latestVersion)

RxSchedulers is the schedulers tools for RxJava2 in Android.

## Usage

### Add dependency:

```groovy
dependencies {

    implementation 'com.github.qingmei2.rxschedulers:rxschedulers:0.1.1'
    // the kotlin extension
    implementation 'com.github.qingmei2.rxschedulers:rxschedulers_support_kt:0.1.1'
}
```

**In Kotlin:**

```kotlin
Observable
        .just(0)
        .delay(5, TimeUnit.SECONDS)
        .switchThread()                             // the extension for kotlin
//      .subscribeOn(Schedulers.io())               // instead of it
//      .observerOn(AndroidScheduler.mainThread())
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
//      .subscribeOn(Schedulers.io())               // instead of it
//      .observerOn(AndroidScheduler.mainThread())
        .subscribe()
```

### RxSchedulerTransformer

RxSchedulerTransformer is a proxy for different Reactive Transformer,So the Developer do not need to implement different **Transformers** based on different types:

```kotlin
interface DelegateTransformer<T, R> : FlowableTransformer<T, R>,
        ObservableTransformer<T, R>,
        MaybeTransformer<T, R>,
        SingleTransformer<T, R>,
        CompletableTransformer
        
class RxSchedulerTransformer<T>(
        private val schedulerProvider: SchedulerProvider = RxSchedulerProvider.INSTANCE
) : DelegateTransformer<T, T> {
    //......
}
```

### RxSchedulerProvider

RxSchedulerProvider is single instance for controlling threads, it is easily for unit testing and managing(using it by dependency injection tools is a good idea, like **[Dagger2](https://github.com/google/dagger)**).

## Another author's libraries using RxJava:

* **[RxImagePicker](https://github.com/qingmei2/RxImagePicker)**: The library which choosing pictures from the Camera or Gallery in Android.

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