package com.padcmyanmar.androidftc.padcx_customviewassignment_nct.mvp.presenters

import com.padcmyanmar.androidftc.padcx_customviewassignment_nct.delegates.ProfileItemDelegate
import com.padcmyanmar.androidftc.padcx_customviewassignment_nct.mvp.views.MainView

interface MainPresenter:ProfileItemDelegate,BasePresenter<MainView> {

}