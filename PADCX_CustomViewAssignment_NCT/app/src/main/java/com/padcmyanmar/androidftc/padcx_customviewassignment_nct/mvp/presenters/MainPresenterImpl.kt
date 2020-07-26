package com.padcmyanmar.androidftc.padcx_customviewassignment_nct.mvp.presenters

import com.padcmyanmar.androidftc.padcx_customviewassignment_nct.mvp.views.MainView

class MainPresenterImpl:MainPresenter,AbstractBasePresenter<MainView>() {
    override fun onUiReady(profileList: ArrayList<Int>) {
        mView?.displayProfileList(profileList)
    }


    override fun onTapProfile() {
        mView?.navigateToProfileDetails()
    }

    override fun onTapAddProfile() {
        mView?.navigateToCreateTask()
    }

}