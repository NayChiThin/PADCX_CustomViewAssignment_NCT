package com.padcmyanmar.androidftc.padcx_customviewassignment_nct.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.padcmyanmar.androidftc.padcx_customviewassignment_nct.R
import com.padcmyanmar.androidftc.padcx_customviewassignment_nct.adapters.TaskListAdapter
import kotlinx.android.synthetic.main.fragment_tasks.*

class TaskFragment : Fragment(){

    private lateinit var mTaskAdapter : TaskListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tasks,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        mTaskAdapter = TaskListAdapter()
        val linearLayoutManager = LinearLayoutManager(this.context,LinearLayoutManager.VERTICAL,false)
        rvTask.layoutManager = linearLayoutManager
        rvTask.adapter = mTaskAdapter
    }
}