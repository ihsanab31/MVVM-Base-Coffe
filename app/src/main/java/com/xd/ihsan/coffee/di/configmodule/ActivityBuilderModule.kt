package com.xd.ihsan.coffee.di.configmodule

import com.xd.ihsan.coffee.view.activities.home.HomeActivity
import com.xd.ihsan.coffee.view.activities.home.HomeActivityModule
import com.xd.ihsan.core.di.scope.ActivityContext
import com.xd.ihsan.coffee.view.activities.login.LoginActivityModule
import com.xd.ihsan.coffee.view.activities.login.LoginActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

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
@Module(
    includes = [
        AndroidSupportInjectionModule::class,
        ViewModelFactoryModule::class
    ]
)
abstract class ActivityBuilderModule {

    @ActivityContext
    @ContributesAndroidInjector(modules = [LoginActivityModule::class])
    abstract fun loginActivity(): LoginActivity

    @ActivityContext
    @ContributesAndroidInjector(modules = [HomeActivityModule::class])
    abstract fun homeActivity(): HomeActivity

}