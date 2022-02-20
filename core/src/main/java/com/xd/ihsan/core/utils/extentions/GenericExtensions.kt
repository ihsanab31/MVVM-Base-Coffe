package com.xd.ihsan.core.utils.extentions

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Patterns

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
fun Boolean?.safeGet(): Boolean = this ?: false

/**
 * Launch 3rd party intent with custom [action] (if specified) & [uriString]
 */
fun Context.launchIntent(action: String = Intent.ACTION_VIEW, uriString: String) =
    startActivity(Intent(action, Uri.parse(uriString)))

val String.Companion.empty: String get() = String()

/**
 * Returns empty string if 'null', else value
 */
fun String?.safeGet(): String = this ?: String.empty


/**
 * get nama class
 *
 * @return Caller class' name
 */
val Any.TAG: String get() = javaClass.simpleName


/**
 * validasi email
 */
fun String?.isEmailValid() = Patterns.EMAIL_ADDRESS.matcher(
    this
).matches()
