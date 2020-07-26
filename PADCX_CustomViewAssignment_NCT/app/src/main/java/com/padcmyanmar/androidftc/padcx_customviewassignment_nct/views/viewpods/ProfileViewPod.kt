package com.padcmyanmar.androidftc.padcx_customviewassignment_nct.views.viewpods

import android.content.Context
import android.util.AttributeSet
import android.widget.RelativeLayout
import kotlinx.android.synthetic.main.profile_viewpod.view.*

class ProfileViewPod @JvmOverloads constructor(
    context:Context,attrs:AttributeSet,defStyleAttr:Int=0
):RelativeLayout(context,attrs,defStyleAttr) {
    fun bindData(closeTask:String,openTask:String,name:String,role:String) {
        tvClosedTask.text = closeTask
        tvOpenTasks.text = openTask
        tvName.text = name
        tvRole.text = role
    }
}