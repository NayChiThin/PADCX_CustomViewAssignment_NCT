package com.padcmyanmar.androidftc.padcx_customviewassignment_nct.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.padcmyanmar.androidftc.padcx_customviewassignment_nct.R
import com.padcmyanmar.androidftc.padcx_customviewassignment_nct.delegates.ProfileItemDelegate
import com.padcmyanmar.androidftc.padcx_customviewassignment_nct.views.viewholder.BaseProfileViewHolder
import com.padcmyanmar.androidftc.padcx_customviewassignment_nct.views.viewholder.BaseViewHolder
import com.padcmyanmar.androidftc.padcx_customviewassignment_nct.views.viewholder.ProfileViewHolder

class ProfileListAdapter(delegate:ProfileItemDelegate):BaseRecyclerAdapter<BaseProfileViewHolder,ArrayList<Int>>() {
    var profileList :ArrayList<Int> = arrayListOf()
    val mDelegate = delegate
    var pos = 0
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProfileViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.profile_list_items,parent,false)
        return ProfileViewHolder(view,mDelegate)
    }

    override fun getItemCount(): Int {
        return profileList.count()
    }
    fun setItemPosition(pos:Int) {
        this.pos = pos
    }
    fun getItemPosition(): Int {
        return pos
    }
    fun setProfileData(list:ArrayList<Int>) {
        profileList = list
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: BaseProfileViewHolder, position: Int) {
        setItemPosition(position)
        holder.bindImage(profileList[position])
    }

}