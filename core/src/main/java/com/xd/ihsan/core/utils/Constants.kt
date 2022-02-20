package com.xd.ihsan.core.utils

import android.os.Looper

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
fun isOnMainThread() = Looper.myLooper() == Looper.getMainLooper()

const val PREF_NAME = "kabobs-app"
const val PRIVATE_MODE = 0
const val IS_LOGIN = "IsLoggedIn"
const val ACCESS_TOKEN = "access_token"
const val RECORD_REQUEST_CODE = 101
const val SELECTED_COFFEE = "selected_coffee"
const val COFFEE = "coffee"