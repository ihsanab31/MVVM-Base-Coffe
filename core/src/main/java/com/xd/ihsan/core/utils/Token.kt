package com.xd.ihsan.core.utils

import com.xd.ihsan.core.di.scope.PerApplication
import com.xd.ihsan.core.utils.extentions.empty

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
class Token {
    private var appToken = String.empty

    fun setToken(token: String) {
        appToken = token
    }

    fun getToken(): String {
        return appToken
    }

    fun clearToken() {
        appToken = String.empty
    }

    fun hasToken() = appToken.isNotEmpty()
}