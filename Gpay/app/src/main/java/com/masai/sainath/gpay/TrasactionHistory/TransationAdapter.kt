package com.masai.sainath.gpay.TrasactionHistory

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.masai.sainath.gpay.R

class TransationAdapter(private val list:ArrayList<TransationModel>,val listener:clicklisten):RecyclerView.Adapter<TransationViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransationViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.transaction_item_layout,parent,false)
        return TransationViewHolder(view,listener)
    }

    override fun onBindViewHolder(holder: TransationViewHolder, position: Int) {
        val transationModel:TransationModel=list[position]
        holder.setdata(transationModel)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}