package com.xd.ihsan.coffee.view.activities.login

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
 * Date     : 11/26/2021
 * ------------------------------
 * This class for
 */
// Copyright (c) 2021 Ihsan Abdurahman. All rights reserved.
@Module(includes = [BaseActivityModule::class])
abstract class LoginActivityModule {

    @Binds
    abstract fun provideActivity(activity: LoginActivity): Activity

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    abstract fun bindLoginViewModel(viewModel: LoginViewModel): ViewModel
}