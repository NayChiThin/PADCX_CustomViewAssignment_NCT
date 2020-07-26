package com.padcmyanmar.androidftc.padcx_customviewassignment_nct.adapters

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.padcmyanmar.androidftc.padcx_customviewassignment_nct.fragments.BlankFragment
import com.padcmyanmar.androidftc.padcx_customviewassignment_nct.fragments.TaskFragment

class MyPagerAdapter(val context: Context,fm:FragmentManager?,var fragments:ArrayList<Fragment>,val categories:ArrayList<String>) : SmartFragmentStatePagerAdapter(fm) {

    public var pos = 0

    override fun getItem(position: Int): Fragment {
        return fragments[position]
    }

    override fun getCount(): Int {
        return fragments.count()
    }

    override fun getPageTitle(position: Int): CharSequence? {
        setPosition(position)
        return categories[position]
    }
    fun getPosition(): Int {
        return pos
    }
    fun setPosition(pos:Int) {
        this.pos = pos
    }
    public fun add(c:Class<Fragment>,title:String,b: Bundle) {
        fragments.add(Fragment.instantiate(context,c.name,b))
        categories.add(title)
    }
}