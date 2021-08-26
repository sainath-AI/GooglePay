package com.masai.sainath.gpay

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class NewAdapter(private val context: Context,private val userlist:ArrayList<Newmodel>):RecyclerView.Adapter<NewAdapter.Newviewholder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Newviewholder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
        return NewAdapter.Newviewholder(view)
    }

    override fun onBindViewHolder(holder: Newviewholder, position: Int) {
        val model1:Newmodel=userlist[position]
        holder.title.text=model1.title
        Glide.with(context).load(model1.Img).into(holder.Img)
    }

    override fun getItemCount(): Int {
        return userlist.size
    }

    class Newviewholder(val view:View):RecyclerView.ViewHolder(view){

        val title: TextView =view.findViewById(R.id.tvnaam)
        val Img: ImageView =view.findViewById(R.id.ciimage)

    }
}