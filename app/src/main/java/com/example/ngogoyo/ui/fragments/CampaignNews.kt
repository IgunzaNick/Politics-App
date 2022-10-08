package com.example.ngogoyo.ui.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ngogoyo.R
import com.example.ngogoyo.adapters.Campaignadapter
import com.example.ngogoyo.models.Campaignnews
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.campaignlayout.*
import kotlinx.android.synthetic.main.fragment_campaign_news.*
import kotlinx.android.synthetic.main.fragment_campaign_news.view.*


class CampaignNews : Fragment(R.layout.fragment_campaign_news) {
    var ref: DatabaseReference?=null



    @SuppressLint("UseRequireInsteadOfGet")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ref = FirebaseDatabase.getInstance().reference.child("Ngogoyo").child("Campaignnews")
            .child("news")
        ref!!.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
             if (snapshot.child("event1").exists()){
                 var body = snapshot.child("event1").getValue().toString()
                 view.event1.setText(body)
             }
                if (snapshot.child("event2").exists()){
                    var body = snapshot.child("event2").getValue().toString()
                    view.event2.setText(body)
                }
                if (snapshot.child("event3").exists()){
                    var body = snapshot.child("event3").getValue().toString()
                    view.event3.setText(body)
                }
                if (snapshot.child("event4").exists()){
                    var body = snapshot.child("event4").getValue().toString()
                    view.event4.setText(body)
                }
            }

            override fun onCancelled(error: DatabaseError) {

            }

        })
        /*
        var layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)

        campaignfrag.setHasFixedSize(true)
        campaignfrag.layoutManager = layoutManager
        campaignfrag.adapter = Campaignadapter(context!!,options =
        FirebaseRecyclerOptions.Builder<Campaignnews>().setQuery(ref!!,Campaignnews::class.java).build()
        )

         */


    }




}