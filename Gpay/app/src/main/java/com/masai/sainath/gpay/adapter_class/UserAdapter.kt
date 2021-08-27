package com.masai.sainath.gpay.adapter_class

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.masai.sainath.gpay.R
import com.masai.sainath.gpay.model_class.usermodel
import kotlin.collections.ArrayList

class userAdapter(private val context: Context, private val uselist: ArrayList<usermodel>):RecyclerView.Adapter<userAdapter.userholder>() {





    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): userholder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
        return userholder(view)
    }

    override fun onBindViewHolder(holder: userholder, position: Int) {
        val model2: usermodel =uselist[position]
        holder.setData(model2)
    }

    override fun getItemCount(): Int {
        return uselist.size
    }



    class userholder(val view:View):RecyclerView.ViewHolder(view){


        val name: TextView =view.findViewById(R.id.tvnaam)
        val imag: ImageView =view.findViewById(R.id.ciimage)
//        val relativeLayout:RelativeLayout = view.findViewById(R.id.relateitem)

        fun  setData(usermodel: usermodel){
            name.text=usermodel.name
            Glide.with(imag).load(usermodel.imag).into(imag)
//            relativeLayout.setOnClickListener {
//                onClickListener.onClick(adapterPosition)
//            }

        }


    }
}