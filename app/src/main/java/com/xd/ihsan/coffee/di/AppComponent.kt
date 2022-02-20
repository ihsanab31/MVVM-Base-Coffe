package com.xd.ihsan.coffee.di

import com.xd.ihsan.core.di.configmodule.AppModule
import com.xd.ihsan.core.di.configmodule.NetModule
import com.xd.ihsan.core.di.scope.ApplicationContext
import com.xd.ihsan.coffee.Coffee
import com.xd.ihsan.coffee.di.configmodule.ActivityBuilderModule
import com.xd.ihsan.coffee.di.configmodule.FragmentViewModelModule
import com.xd.ihsan.coffee.di.configmodule.ServicesModule
import dagger.Component
import dagger.android.AndroidInjector
import javax.inject.Singleton

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
@ApplicationContext
@Singleton
@Component(
    modules = [
        ActivityBuilderModule::class,
        AppModule::class,
        NetModule::class,
        ServicesModule::class,
        FragmentViewModelModule::class
    ]
)
interface AppComponent : AndroidInjector<Coffee>