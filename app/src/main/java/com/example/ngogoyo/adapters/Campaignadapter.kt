package com.example.ngogoyo.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ngogoyo.R
import com.example.ngogoyo.models.Campaignnews
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.firebase.database.DatabaseReference

class Campaignadapter( var context: Context, options: FirebaseRecyclerOptions<Campaignnews>)
    : FirebaseRecyclerAdapter<Campaignnews, Campaignadapter.ViewHolder>(
    options)


{
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var news: String? = null
        fun bindView(campaignnews: Campaignnews,context: Context){
            var news1 = itemView.findViewById<TextView>(R.id.event1)
            //set the strings
            news = campaignnews.news
            news1.text = news

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).
            inflate(R.layout.campaignlayout,parent,false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int, model: Campaignnews) {
        holder.bindView(model,context)
        var news = holder.itemView.findViewById<TextView>(R.id.event1)
        news.text = model.news

    }


}