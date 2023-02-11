package com.jonas.tiskus.kmm.demo.android

import android.app.Application
import com.jonas.tiskus.kmm.demo.shared.Shared
import com.jonas.tiskus.kmm.demo.shared.config.Environment

class App: Application() {

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Shared.init(Environment.DEV)
        } else {
            Shared.init(Environment.PRODUCTION)
        }
    }

}