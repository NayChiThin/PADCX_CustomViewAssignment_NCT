package com.padcmyanmar.androidftc.padcx_customviewassignment_nct.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.padcmyanmar.androidftc.padcx_customviewassignment_nct.R
import com.padcmyanmar.androidftc.padcx_customviewassignment_nct.views.viewholder.BaseTaskViewHolder
import com.padcmyanmar.androidftc.padcx_customviewassignment_nct.views.viewholder.TaskViewHolder

class TaskListAdapter : BaseRecyclerAdapter<BaseTaskViewHolder,ArrayList<Int>>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.task_list_items,parent,false)
        return TaskViewHolder(view)
    }

    override fun getItemCount(): Int {
        return 4
    }

    override fun onBindViewHolder(holder: BaseTaskViewHolder, position: Int) {

    }
}
