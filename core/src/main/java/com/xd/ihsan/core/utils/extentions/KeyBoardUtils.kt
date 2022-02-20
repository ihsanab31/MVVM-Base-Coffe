package com.xd.ihsan.core.utils.extentions

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager

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
object KeyBoardUtils {
    fun showKeyboard(view: View) {
        getInputMethodManager(view.context)
            .showSoftInput(view, InputMethodManager.SHOW_IMPLICIT)
    }

    fun hideKeyboard(view: View) {
        getInputMethodManager(view.context)
            .hideSoftInputFromWindow(view.windowToken, 0)
    }

    fun isKeyboardShowing(context: Context) =
        getInputMethodManager(context).isAcceptingText

    private fun getInputMethodManager(context: Context) =
        context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
}