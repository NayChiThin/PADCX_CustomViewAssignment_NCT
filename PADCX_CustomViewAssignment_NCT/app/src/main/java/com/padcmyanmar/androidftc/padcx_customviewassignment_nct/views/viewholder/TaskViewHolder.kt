package com.padcmyanmar.androidftc.padcx_customviewassignment_nct.views.viewholder

import android.util.Log
import android.view.View

class TaskViewHolder(itemView: View):BaseTaskViewHolder(itemView) {
    init {
        itemView.setOnClickListener {
            Log.d("TAP","Clicked task")
        }
    }
}