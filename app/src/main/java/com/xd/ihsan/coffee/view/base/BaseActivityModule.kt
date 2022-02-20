package com.xd.ihsan.coffee.view.base

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.FragmentManager
import com.xd.ihsan.core.di.scope.ActivityContext
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.support.DaggerAppCompatActivity

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
@Module
abstract class BaseActivityModule {
    companion object {

        @Provides
        @ActivityContext
        fun provideFragmentManager(activity: AppCompatActivity): FragmentManager {
            return activity.supportFragmentManager
        }

    }

    @Binds
    abstract fun provideActivity(activity: BaseActivity<ViewDataBinding, BaseViewModel>): Activity

    @Binds
    @ActivityContext
    abstract fun bindAppCompatActivity(activity: BaseActivity<ViewDataBinding, BaseViewModel>): DaggerAppCompatActivity

    @Binds
    @ActivityContext
    abstract fun bindActivity(activity: DaggerAppCompatActivity): Activity

    @ActivityContext
    @Binds
    abstract fun bindActivityContext(activity: Activity): Context
}