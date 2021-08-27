package com.masai.sainath.gpay.adapter_class

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.masai.sainath.gpay.OnClickListener
import com.masai.sainath.gpay.R
import com.masai.sainath.gpay.model_class.Model
import com.masai.sainath.gpay.model_class.usermodel

class MyAdapter(val context:Context,private val datalist:ArrayList<Model>,val onClickListener: OnClickListener):RecyclerView.Adapter<MyAdapter.MyviewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyviewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
         return MyviewHolder(view,onClickListener)
    }

    override fun onBindViewHolder(holder: MyviewHolder, position: Int) {
        val model: Model =datalist[position]
        holder.setData(model)
    }

    override fun getItemCount(): Int {
        return datalist.size
    }


    class MyviewHolder( val view:View,val onClickListener: OnClickListener):RecyclerView.ViewHolder(view){


        val naam1:TextView=view.findViewById(R.id.tvnaam)
        val Image:ImageView=view.findViewById(R.id.ciimage)
        val relativeLayout: RelativeLayout = view.findViewById(R.id.relateitem)

        fun  setData(usermodel: Model){
            naam1.text=usermodel.naam1
            Glide.with(Image).load(usermodel.Image).into(Image)
            relativeLayout.setOnClickListener {
                onClickListener.onClick(adapterPosition,usermodel)
            }

        }

    }
}