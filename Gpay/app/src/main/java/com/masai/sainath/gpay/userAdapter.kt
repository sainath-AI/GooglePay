package com.masai.sainath.gpay

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class userAdapter(private val context: Context,private val uselist:ArrayList<usermodel>):RecyclerView.Adapter<userAdapter.userholder>() {





    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): userholder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
        return userAdapter.userholder(view)
    }

    override fun onBindViewHolder(holder: userholder, position: Int) {
        val model2:usermodel=uselist[position]
        holder.name.text=model2.name
        Glide.with(context).load(model2.imag).into(holder.imag)
    }

    override fun getItemCount(): Int {
        return uselist.size
    }
    class userholder(val view:View):RecyclerView.ViewHolder(view){

        val name: TextView =view.findViewById(R.id.tvnaam)
        val imag: ImageView =view.findViewById(R.id.ciimage)

    }
}