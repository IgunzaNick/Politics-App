package com.example.ngogoyo.ui.fragments


import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment

import android.view.View
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.ngogoyo.R
import com.example.ngogoyo.adapters.NewsviewpagerAdapter
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_news.*
import kotlinx.android.synthetic.main.fragment_news.view.*


class NewsFragment : Fragment(R.layout.fragment_news) {



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val adapter = NewsviewpagerAdapter(this)
        adapter.addFragment(CampaignNews(),"Campaign News")
        adapter.addFragment(Internationalnews(),"International News")
        view.viewpager.adapter = adapter
       view.tabs.setTabTextColors(Color.BLACK,Color.GREEN)
        TabLayoutMediator(view.tabs,view.viewpager){
            tabs,position ->
            tabs.text = adapter.getPageTitle(position)

        }.attach()


    }

}


