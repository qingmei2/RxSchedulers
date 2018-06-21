package com.qingmei2.sample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.qingmei2.rxschedulers_support_kt.switchThread
import io.reactivex.Observable
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Observable.just(0)
                .delay(5, TimeUnit.SECONDS)
                .switchThread()
                .subscribe({
                    Toast.makeText(this, "onNext: Int = $it", Toast.LENGTH_SHORT).show()
                })
    }
}
