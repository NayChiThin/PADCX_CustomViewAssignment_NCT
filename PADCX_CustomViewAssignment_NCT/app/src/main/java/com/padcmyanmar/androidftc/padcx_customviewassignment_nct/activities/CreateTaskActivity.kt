package com.padcmyanmar.androidftc.padcx_customviewassignment_nct.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.padcmyanmar.androidftc.padcx_customviewassignment_nct.R
import com.padcmyanmar.androidftc.padcx_customviewassignment_nct.adapters.ProfileListAdapter
import com.padcmyanmar.androidftc.padcx_customviewassignment_nct.mvp.presenters.TaskPresenter
import com.padcmyanmar.androidftc.padcx_customviewassignment_nct.mvp.presenters.TaskPresenterImpl
import com.padcmyanmar.androidftc.padcx_customviewassignment_nct.mvp.views.TaskView
import com.padcmyanmar.androidftc.padcx_customviewassignment_nct.views.components.ItemDecorator
import kotlinx.android.synthetic.main.activity_create_task.*
import kotlinx.android.synthetic.main.activity_create_task.rvProfile
import kotlinx.android.synthetic.main.activity_main.*

class CreateTaskActivity : BaseActivity(),TaskView {

    private lateinit var mPresenter : TaskPresenter
    private lateinit var mProfileListAdapter : ProfileListAdapter
    private val profileList : ArrayList<Int> = arrayListOf(R.drawable.avatar2,R.drawable.avatar,R.drawable.avatar3,R.mipmap.ic_add_profile)

    companion object {
        fun newIntent(context:Context):Intent {
            return Intent(context,CreateTaskActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_task)

        setUpPresenter()
        setUpRecyclerView()
        setUpSpinner()
        mPresenter.onUiReady(profileList)

        ivBackToMain.setOnClickListener {
            mPresenter.onTapBackButton()
        }
    }
    private fun setUpSpinner() {
        val teams : Array<String> = arrayOf("avsda Team","Team 2","Example Team")
        val teamSpinnerAdapter : ArrayAdapter<String> = ArrayAdapter(this,R.layout.spinner_item,teams)
        teamSpinnerAdapter.setDropDownViewResource(R.layout.spinner_item)
        spinner2.adapter = teamSpinnerAdapter

        val date : Array<String> = arrayOf("\uD83D\uDCC5Dec24,2019","\uD83D\uDCC5Dec30,2019")
        val dateSpinnerAdapter : ArrayAdapter<String> = ArrayAdapter(this,R.layout.spinner_item,date)
        dateSpinnerAdapter.setDropDownViewResource(R.layout.spinner_item)
        spEndDate.adapter = dateSpinnerAdapter
        spStartDate.adapter = dateSpinnerAdapter
    }
    private fun setUpPresenter() {
        mPresenter = ViewModelProviders.of(this).get(TaskPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }
    private fun setUpRecyclerView() {
        mProfileListAdapter = ProfileListAdapter(mPresenter)
        val linearLayoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        rvProfile.layoutManager = linearLayoutManager
        rvProfile.adapter = mProfileListAdapter
        rvProfile.addItemDecoration(ItemDecorator(-30))
    }

    override fun displayProfileList(list: ArrayList<Int>) {
        mProfileListAdapter.setProfileData(list)
    }

    override fun navigateToMainScreen() {
        startActivity(MainActivity.newIntent(this))
        finish()
    }
}
