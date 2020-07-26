package com.padcmyanmar.androidftc.padcx_customviewassignment_nct.mvp.views

interface MainView : BaseView {
    fun displayProfileList(list:ArrayList<Int>)
    fun navigateToProfileDetails()
    fun navigateToCreateTask()
}