package com.xd.ihsan.coffee

import android.app.Application
import com.google.firebase.ktx.Firebase
import com.google.firebase.messaging.ktx.messaging
import com.xd.ihsan.core.di.configmodule.AppModule
import com.xd.ihsan.core.di.configmodule.NetModule
import com.xd.ihsan.coffee.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

/**
 * Created by
 * Name     : Ihsan Abdurahman
 * Email    : ihsanab31@gmail.com
 * WA       : 085749729115
 * Date     : 11/26/2021
 * ------------------------------
 * This class for
 */
// Copyright (c) 2021 Ihsan Abdurahman. All rights reserved.
class Coffee : Application(), HasAndroidInjector {

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    override fun onCreate() {
        super.onCreate()
        Firebase.messaging.isAutoInitEnabled = true
        DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .netModule(NetModule(BuildConfig.BASE_URL_PROD))
            .build()
            .inject(this)
    }

    override fun androidInjector(): AndroidInjector<Any> = androidInjector
}