package com.xd.ihsan.coffee.view.activities.home

import android.app.Activity
import androidx.lifecycle.ViewModel
import com.xd.ihsan.coffee.di.ViewModelKey
import com.xd.ihsan.coffee.view.base.BaseActivityModule
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by
 * Name     : Ihsan Abdurahman
 * Email    : ihsanab31@gmail.com
 * WA       : 085749729115
 * Date     : 2/20/2022
 * ------------------------------
 * This class for
 */
// Copyright (c) 2022 Ihsan Abdurahman. All rights reserved.
@Module(includes = [BaseActivityModule::class])
abstract class HomeActivityModule {
    @Binds
    abstract fun provideActivity(activity: HomeActivity): Activity

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindHomeViewModel(viewModel: HomeViewModel): ViewModel
}