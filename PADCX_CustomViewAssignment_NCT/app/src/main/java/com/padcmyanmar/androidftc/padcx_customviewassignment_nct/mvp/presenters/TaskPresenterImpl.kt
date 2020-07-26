package com.padcmyanmar.androidftc.padcx_customviewassignment_nct.mvp.presenters

import com.padcmyanmar.androidftc.padcx_customviewassignment_nct.mvp.views.TaskView

class TaskPresenterImpl:TaskPresenter,AbstractBasePresenter<TaskView>() {
    override fun onTapBackButton() {
        mView?.navigateToMainScreen()
    }

    override fun onTapProfile() {

    }

    override fun onTapAddProfile() {

    }

    override fun onUiReady(profileList: ArrayList<Int>) {
        mView?.displayProfileList(profileList)
    }
}