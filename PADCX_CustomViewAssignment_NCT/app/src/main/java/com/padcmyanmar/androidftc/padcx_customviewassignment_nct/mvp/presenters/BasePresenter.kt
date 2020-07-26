package com.padcmyanmar.androidftc.padcx_customviewassignment_nct.mvp.presenters

import com.padcmyanmar.androidftc.padcx_customviewassignment_nct.mvp.views.BaseView

interface BasePresenter<T:BaseView> {
    fun initPresenter(view:T)
    fun onUiReady(profileList:ArrayList<Int>)
}