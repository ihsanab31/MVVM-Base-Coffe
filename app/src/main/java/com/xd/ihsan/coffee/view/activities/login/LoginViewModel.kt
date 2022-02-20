package com.xd.ihsan.coffee.view.activities.login

import android.app.Activity
import android.content.Intent
import com.libizo.CustomEditText
import com.xd.ihsan.coffee.R
import com.xd.ihsan.coffee.view.activities.home.HomeActivity
import com.xd.ihsan.coffee.view.base.BaseViewModel
import com.xd.ihsan.core.utils.extentions.safeGet
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
class LoginViewModel @Inject constructor() : BaseViewModel() {
    fun check(et_pin: CustomEditText, activity: Activity) {
        if (et_pin.text.toString().safeGet() == "") {
            et_pin.error = activity.resources.getString(R.string.require)
        } else if (et_pin.text.toString().safeGet() != "2022") {
            et_pin.error = activity.resources.getString(R.string.invalid)
        }else{
            activity.startActivity(Intent(activity, HomeActivity::class.java))
        }
    }
}