package com.example.ngogoyo.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter


class NewsviewpagerAdapter(supportFragmentManager:Fragment):FragmentStateAdapter(supportFragmentManager) {
    private val mfragmentlist = ArrayList<Fragment>()
    private val mfragmentTitlelist = ArrayList<String>()


    fun getPageTitle(position: Int): CharSequence? {
        return mfragmentTitlelist[position]
    }
    fun addFragment(fragment: Fragment,title:String){
        mfragmentlist.add(fragment)
        mfragmentTitlelist.add(title)
    }

    override fun getItemCount(): Int {

        return mfragmentlist.size
    }

    override fun createFragment(position: Int): Fragment {

        return mfragmentlist[position]
    }
}