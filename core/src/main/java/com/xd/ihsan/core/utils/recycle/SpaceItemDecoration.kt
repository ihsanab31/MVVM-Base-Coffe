package com.xd.ihsan.core.utils.recycle

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

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
class SpaceItemDecoration (private val spacing: Int) : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        val position = parent.getChildAdapterPosition(view)
        outRect.left = spacing
        outRect.right = spacing
        outRect.bottom = spacing

        if (position < 1) outRect.top = spacing
    }
}