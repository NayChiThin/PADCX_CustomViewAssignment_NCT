package com.padcmyanmar.androidftc.padcx_customviewassignment_nct.views.components

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class ItemDecorator(val mSpace : Int) : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        val position : Int = parent.getChildAdapterPosition(view)
        outRect.right = mSpace
    }
}