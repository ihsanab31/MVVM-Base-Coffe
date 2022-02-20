package com.xd.ihsan.core.utils.preference

import android.content.Context
import com.xd.ihsan.core.utils.Token
import com.xd.ihsan.core.utils.extentions.AppLogger
import dagger.Module
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.subjects.PublishSubject
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
@Module
class SessionManager @Inject constructor(
    private val token: Token,
    private val preferenceManager: PrefManager,
) {

    private val sessionPublisher: PublishSubject<String> =
        PublishSubject.create<String>()


    fun subscribeSession(onNext: Consumer<String>) =
        sessionPublisher
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(onNext)!!

    fun sessionExpired() {
        clearSession()
        AppLogger.e("Session Manager", "ON SESSION EXPIRED")
        sessionPublisher.onNext("on session expired")
    }

    fun initPrefManager(activity: Context) {
        preferenceManager.PrefManager(activity)
    }

    fun clearSession() {
        token.clearToken()
    }

    fun loguoutApp() {
        preferenceManager.logoutUser()
    }

    fun hasToken() = token.hasToken()

    fun setToken(tokenValue: String) {
        preferenceManager.saveAccessToken(tokenValue)
        token.setToken(
            tokenValue
        )
    }

}