package com.example.ngogoyo.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.ngogoyo.R
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds
import com.google.firebase.database.*
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.homefragment.*


class HomeFragment : Fragment(R.layout.homefragment) {
    var mdatabase: DatabaseReference?=null


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        MobileAds.initialize(view.context)
        val adrequest = AdRequest.Builder().build()
        AdView.loadAd(adrequest)
        mdatabase = FirebaseDatabase.getInstance().reference.child("Ngogoyo")
        mdatabase!!.addValueEventListener(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                var image = snapshot.child("image").value.toString()
                Picasso.with(context).load(image).into(ngogoyoimage)

            }

            override fun onCancelled(error: DatabaseError) {


            }
        })




    }

}