package com.padcmyanmar.androidftc.padcx_customviewassignment_nct.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.padcmyanmar.androidftc.padcx_customviewassignment_nct.R
import com.padcmyanmar.androidftc.padcx_customviewassignment_nct.adapters.ProfileListAdapter
import com.padcmyanmar.androidftc.padcx_customviewassignment_nct.adapters.TaskListAdapter
import com.padcmyanmar.androidftc.padcx_customviewassignment_nct.fragments.BottomSheetFragment
import com.padcmyanmar.androidftc.padcx_customviewassignment_nct.mvp.presenters.MainPresenter
import com.padcmyanmar.androidftc.padcx_customviewassignment_nct.mvp.presenters.MainPresenterImpl
import com.padcmyanmar.androidftc.padcx_customviewassignment_nct.mvp.views.MainView
import com.padcmyanmar.androidftc.padcx_customviewassignment_nct.views.components.ItemDecorator
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.bottom_sheet.*
import kotlinx.android.synthetic.main.content_main.*


class MainActivity : BaseActivity(),MainView {

    private lateinit var mPresenter : MainPresenter
    private lateinit var mProfileListAdapter : ProfileListAdapter
    private lateinit var mTaskListAdapter: TaskListAdapter
    private val profileList : ArrayList<Int> = arrayListOf(R.drawable.avatar2,R.drawable.avatar,R.drawable.avatar3,R.mipmap.ic_add_profile)
    private lateinit var bottomSheetDialogFragment :BottomSheetFragment

    companion object {
        fun newIntent(context: Context):Intent {
            return Intent(context,MainActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        setUpPresenter()

        setUpRecyclerView()
        mPresenter.onUiReady(profileList)

    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProviders.of(this).get(MainPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

    private fun setUpRecyclerView() {
        mProfileListAdapter = ProfileListAdapter(mPresenter)
        mTaskListAdapter = TaskListAdapter()
        val linearLayoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        rvProfile.layoutManager = linearLayoutManager
        rvProfile.adapter = mProfileListAdapter
        rvProfile.addItemDecoration(ItemDecorator(-30))

        val linearLayoutManager2 = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        rvTask.layoutManager = linearLayoutManager2
        rvTask.adapter = mTaskListAdapter

    }

    override fun displayProfileList(list: ArrayList<Int>) {
        mProfileListAdapter.setProfileData(list)
    }

    override fun navigateToProfileDetails() {
        bottomSheetDialogFragment = BottomSheetFragment()
        bottomSheetDialogFragment.show(supportFragmentManager,bottomSheetDialogFragment.tag)

    }

    override fun navigateToCreateTask() {
        Log.d("TAG","Clicked add profile")
        startActivity(CreateTaskActivity.newIntent(this))
        finish()
    }
}
