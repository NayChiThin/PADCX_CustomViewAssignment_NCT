package com.padcmyanmar.androidftc.padcx_customviewassignment_nct.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TableLayout
import androidx.fragment.app.Fragment
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.tabs.TabLayout
import com.padcmyanmar.androidftc.padcx_customviewassignment_nct.R
import com.padcmyanmar.androidftc.padcx_customviewassignment_nct.adapters.MyPagerAdapter
import kotlinx.android.synthetic.main.bottom_sheet.*


class BottomSheetFragment: BottomSheetDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.bottom_sheet, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        btnMessage.setOnClickListener {
            Log.d("ButtonClick", "Clicked Message")
        }

        val fragments : ArrayList<Fragment> = buildFragments()
        val categories : ArrayList<String> = arrayListOf("Project Tasks","Contacts","About you")


        val viewPagerAdapter = MyPagerAdapter(this.requireContext(),childFragmentManager,fragments,categories)
        viewPager.adapter = viewPagerAdapter

        tabLayout.setupWithViewPager(viewPager)

        fabClose.setOnClickListener {
            closeDialog()
        }
        //Add a new Fragment to the list with bundle
        /*var b : Bundle = Bundle()
        b.putInt("position",fragments.size)
        val title:String = "Extra"
        viewPagerAdapter.add(BlankFragment().javaClass,title,b)
        viewPagerAdapter.notifyDataSetChanged()*/
    }

    private fun buildFragments(): ArrayList<Fragment> {
        val fragments: ArrayList<Fragment> = ArrayList<Fragment>()
        for (i in 0 until 3) {
            val b = Bundle()
            b.putInt("position", i)
            when(i) {
                0 -> fragments.add(Fragment.instantiate(this.context,TaskFragment::class.java.name,b))
                else -> fragments.add(Fragment.instantiate(this.context,BlankFragment::class.java.name,b))
            }
        }
        return fragments
    }
    fun closeDialog() {
        dialog.dismiss()
    }

}