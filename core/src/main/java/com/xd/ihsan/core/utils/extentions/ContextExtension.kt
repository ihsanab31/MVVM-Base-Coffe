package com.xd.ihsan.core.utils.extentions

import android.app.Activity
import android.content.Intent

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
fun <T> Activity.relaunchApp(classToLaunch: Class<T>, animate: Boolean = false) {
    startActivity(Intent(this, classToLaunch))
    if (animate.not()) {
        overridePendingTransition(0, 0)
    }
}

fun <T> Activity.relaunchAppWitClose(classToLaunch: Class<T>, animate: Boolean = false) {
    startActivity(Intent(this, classToLaunch))
    if (animate.not()) {
        overridePendingTransition(0, 0)
    }
    finishAffinity()
}