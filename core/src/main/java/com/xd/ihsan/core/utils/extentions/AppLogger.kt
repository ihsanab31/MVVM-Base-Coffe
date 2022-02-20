package com.xd.ihsan.core.utils.extentions

import com.xd.ihsan.core.BuildConfig
import timber.log.Timber

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
object AppLogger {
    init {
        if (BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())
    }

    fun d(
        tag: String,
        message: String,
        vararg params: Any
    ) = Timber.tag(tag).d(message, params)

    fun d(
        tag: String,
        throwable: Throwable,
        message: String,
        vararg params: Any
    ) = Timber.tag(tag).d(throwable, message, params)

    fun i(
        tag: String,
        message: String,
        vararg params: Any
    ) = Timber.tag(tag).i(message, params)

    fun i(
        tag: String,
        throwable: Throwable,
        message: String,
        vararg params: Any
    ) = Timber.tag(tag).i(throwable, message, params)

    fun w(
        tag: String,
        message: String,
        vararg params: Any
    ) = Timber.tag(tag).w(message, params)

    fun w(
        tag: String,
        throwable: Throwable,
        message: String,
        vararg params: Any
    ) = Timber.tag(tag).w(throwable, message, params)

    fun e(
        tag: String,
        message: String,
        vararg params: Any
    ) = Timber.tag(tag).e(message, params)

    fun e(
        tag: String,
        throwable: Throwable,
        message: String,
        vararg params: Any
    ) = Timber.tag(tag).e(throwable, message, params)
}