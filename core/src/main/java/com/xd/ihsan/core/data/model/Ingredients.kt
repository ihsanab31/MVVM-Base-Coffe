package com.xd.ihsan.core.data.model

/**
 * Created by
 * Name     : Ihsan Abdurahman
 * Email    : ihsanab31@gmail.com
 * WA       : 085749729115
 * Date     : 2/20/2022
 * ------------------------------
 * This class for
 */
// Copyright (c) 2022 Ihsan Abdurahman. All rights reserved.
class Ingredients(name: String) {

    private var name: String

    init {
        this.name = name
    }
    fun getName(): String {
        return name
    }
    fun setName(name: String?) {
        this.name = name!!
    }

}