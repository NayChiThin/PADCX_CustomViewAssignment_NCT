package com.padcmyanmar.androidftc.padcx_customviewassignment_nct.views.viewholder

import android.util.Log
import android.view.View
import androidx.core.graphics.drawable.toDrawable
import com.bumptech.glide.Glide
import com.padcmyanmar.androidftc.padcx_customviewassignment_nct.R
import com.padcmyanmar.androidftc.padcx_customviewassignment_nct.delegates.ProfileItemDelegate
import com.padcmyanmar.androidftc.padcx_customviewassignment_nct.views.viewpods.ProfileViewPod
import kotlinx.android.synthetic.main.bottom_sheet.view.*
import kotlinx.android.synthetic.main.profile_list_items.view.*
import java.util.ArrayList

class ProfileViewHolder(itemView:View,private val mDelegate:ProfileItemDelegate):BaseProfileViewHolder(itemView) {

//    private val mProfileViewPod = itemView.profileViewPod as ProfileViewPod

    init {
        itemView.setOnClickListener {

            if(layoutPosition == 3) {
                mDelegate.onTapAddProfile()
            }else {
                mDelegate.onTapProfile()
            }
        }
    }

    override fun bindImage(image: Int) {
        itemView.ivProfile.setImageResource(image)

//        mProfileViewPod.bindData("200","2","Zachary","Frontend")
    }
}