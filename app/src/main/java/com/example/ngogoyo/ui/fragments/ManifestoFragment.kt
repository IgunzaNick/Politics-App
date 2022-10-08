package com.example.ngogoyo.ui.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ngogoyo.R
import com.example.ngogoyo.adapters.Manifestoadapter
import com.example.ngogoyo.models.Manifesto
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.manifestofragment.*
import kotlinx.android.synthetic.main.manifestofragment.view.*
import kotlinx.android.synthetic.main.manifestolayout.*
import kotlinx.android.synthetic.main.manifestolayout.view.*


class ManifestoFragment : Fragment(R.layout.manifestofragment) {
        var ref: DatabaseReference?=null

    @SuppressLint("UseRequireInsteadOfGet")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ref = FirebaseDatabase.getInstance().reference.child("Ngogoyo").child("Manifesto")
        ref!!.addValueEventListener(object: ValueEventListener{
            override fun onDataChange(snapshot:DataSnapshot){
                if (snapshot.child("manifesto1").exists()){
                    var body = snapshot.child("manifesto1").getValue().toString()
                    view.manifesto.setText(body)
                }
                if (snapshot.child("manifesto2").exists()){
                    var body = snapshot.child("manifesto2").getValue().toString()
                    view.manifesto2.setText(body)
                }
                if (snapshot.child("manifesto3").exists()){
                    var body = snapshot.child("manifesto3").getValue().toString()
                    view.manifesto3.setText(body)
                }


            }
            override fun onCancelled(error:DatabaseError){
                Snackbar.make(view,"Check Internet Connection",Snackbar.LENGTH_SHORT).show()

            }

        })
            /*
        var layoutmanager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
        view.manifestofrag.setHasFixedSize(true)
        view.manifestofrag.layoutManager = layoutmanager
        view.manifestofrag.adapter = Manifestoadapter(
            context!!, options =
        FirebaseRecyclerOptions.Builder<Manifesto>().setQuery(ref!!,Manifesto::class.java).build()
        )

             */


    }

}