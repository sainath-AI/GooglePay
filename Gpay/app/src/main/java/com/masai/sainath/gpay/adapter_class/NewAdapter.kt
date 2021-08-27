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
import com.masai.sainath.gpay.model_class.Newmodel

class NewAdapter(private val context: Context,private val userlist:ArrayList<Newmodel>):RecyclerView.Adapter<NewAdapter.Newviewholder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Newviewholder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
        return Newviewholder(view)
    }

    override fun onBindViewHolder(holder: Newviewholder, position: Int) {
        val model1: Newmodel =userlist[position]
        holder.setData(model1)
    }

    override fun getItemCount(): Int {
        return userlist.size
    }

    class Newviewholder(val view:View):RecyclerView.ViewHolder(view){

        val naam1:TextView=view.findViewById(R.id.tvnaam)
        val Image:ImageView=view.findViewById(R.id.ciimage)
//        val relativeLayout: RelativeLayout = view.findViewById(R.id.relateitem)

        fun  setData(usermodel: Newmodel){
            naam1.text=usermodel.title
            Glide.with(Image).load(usermodel.Img).into(Image)
//            relativeLayout.setOnClickListener {
//                onClickListener.onClick(adapterPosition)
//            }

        }
    }
}