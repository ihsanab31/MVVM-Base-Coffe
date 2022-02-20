package com.xd.ihsan.coffee.view.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.xd.ihsan.core.utils.event.Event
import com.xd.ihsan.core.utils.preference.SessionManager
import io.reactivex.functions.Consumer
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
abstract class BaseViewModel : ViewModel() {

    @Inject
    lateinit var mSessionManager: SessionManager

    private var _showLoading =
        MutableLiveData<Event<Pair<Boolean, String>>>()
    val showLoadingLiveData: LiveData<Event<Pair<Boolean, String>>>
        get() = _showLoading

    fun subscribeSessionObserver(consumer: Consumer<String>) =
        mSessionManager.subscribeSession(consumer)

    fun clearSession() = mSessionManager.clearSession()
}