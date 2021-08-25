package com.masai.sainath.gpay

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MyAdapter(val context:Context,private val datalist:ArrayList<Model>):RecyclerView.Adapter<MyAdapter.MyviewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyviewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
         return MyviewHolder(view)
    }

    override fun onBindViewHolder(holder: MyviewHolder, position: Int) {
        val model:Model=datalist[position]
        holder.naam1.text=model.naam1
        Glide.with(context).load(model.Image).into(holder.Image)
    }

    override fun getItemCount(): Int {
        return datalist.size
    }


    class MyviewHolder( val view:View):RecyclerView.ViewHolder(view){


        val naam1:TextView=view.findViewById(R.id.tvnaam)
        val Image:ImageView=view.findViewById(R.id.ciimage)

    }
}