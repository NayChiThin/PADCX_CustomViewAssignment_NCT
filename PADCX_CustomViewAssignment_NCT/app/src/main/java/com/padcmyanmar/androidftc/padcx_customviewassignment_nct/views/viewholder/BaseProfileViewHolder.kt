package com.padcmyanmar.androidftc.padcx_customviewassignment_nct.views.viewholder

import android.view.View
import java.util.ArrayList

abstract class BaseProfileViewHolder(itemView:View):BaseViewHolder(itemView) {

    abstract fun bindImage(image:Int)
}