package com.xd.ihsan.core.utils.preference

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import com.xd.ihsan.core.di.scope.PerApplication
import com.xd.ihsan.core.utils.ACCESS_TOKEN
import com.xd.ihsan.core.utils.IS_LOGIN
import com.xd.ihsan.core.utils.PREF_NAME
import com.xd.ihsan.core.utils.PRIVATE_MODE

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
@PerApplication
@SuppressLint("NewApi")
class PrefManager {
    private lateinit var pref: SharedPreferences
    private var editor: SharedPreferences.Editor? = null
    private var _context: Context? = null

    @SuppressLint("CommitPrefEdits", "WrongConstant")
    fun PrefManager(context: Context) {
        _context = context
        pref = context.getSharedPreferences(
            PREF_NAME,
            PRIVATE_MODE
        )
        editor = pref.edit()
    }

    fun saveAccessToken(access_token: String?) {
        editor!!.putBoolean(IS_LOGIN, true)
        editor!!.putString(ACCESS_TOKEN, access_token)
        editor!!.apply()
        editor!!.commit()
    }


    fun logoutUser() {
        editor!!.clear()
        editor!!.commit()
    }
}