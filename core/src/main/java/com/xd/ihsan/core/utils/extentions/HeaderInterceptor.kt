package com.xd.ihsan.core.utils.extentions

import com.xd.ihsan.core.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

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
class HeaderInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response = chain.run {
        proceed(
            request()
                .newBuilder()
//                .addHeader("app_key", BuildConfig.API_KEY)
//                .addHeader("pass", BuildConfig.API_KEY)
//                .addHeader("platform", BuildConfig.platform)
                .build()
        )
    }
}