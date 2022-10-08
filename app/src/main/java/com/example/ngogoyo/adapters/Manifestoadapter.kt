package com.example.ngogoyo.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ngogoyo.R
import com.example.ngogoyo.models.Manifesto
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.firebase.database.DatabaseReference
import org.w3c.dom.Text

class Manifestoadapter(var context: Context,
    options: FirebaseRecyclerOptions<Manifesto>):FirebaseRecyclerAdapter<Manifesto
        , Manifestoadapter.ViewHolder>(options) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.manifestolayout, parent, false)
        )

    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int,
        model: Manifesto
    ) {
        holder.bindView(model, context)
        var manifesto1 = holder!!.itemView.findViewById<TextView>(R.id.manifesto)
        manifesto1.text = model.manifesto1
        var manifesto2 = holder!!.itemView.findViewById<TextView>(R.id.manifesto2)
        manifesto2.text = model.manifesto2
        var manifesto3 = holder!!.itemView.findViewById<TextView>(R.id.manifesto3)
        manifesto3.text = model.manifesto3
        var manifesto4 = holder.itemView.findViewById<TextView>(R.id.manifesto4)
        manifesto4.text = model.manifesto4


    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var manifesto1: String? = null
        var manifesto2:String?=null
        var manifesto3: String?=null
        var manifesto4: String?=null

        fun bindView(manifesto: Manifesto, context: Context) {
            var manifesto11 = itemView.findViewById<TextView>(R.id.manifesto)
            var manifesto22 = itemView.findViewById<TextView>(R.id.manifesto2)
            var manifesto33 = itemView.findViewById<TextView>(R.id.manifesto3)
            var manifesto44 = itemView.findViewById<TextView>(R.id.manifesto4)

            //setting the required strings
            manifesto1 = manifesto.manifesto1
            manifesto2 = manifesto.manifesto2
            manifesto3 = manifesto.manifesto3
            manifesto4 = manifesto.manifesto4


            manifesto11.text = manifesto1
            manifesto22.text = manifesto2
            manifesto33.text = manifesto3
            manifesto44.text = manifesto4


        }

    }
}



