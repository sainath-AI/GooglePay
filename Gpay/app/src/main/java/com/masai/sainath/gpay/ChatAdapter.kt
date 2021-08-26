package com.masai.sainath.gpay

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ChatAdapter( private  val receiverModelList: List<ReceiverModel>) :
    RecyclerView.Adapter<RecieverViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecieverViewHolder {
        val view =LayoutInflater.from(parent.context).inflate(R.layout.sender_layout_item,parent,false)
        return RecieverViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecieverViewHolder, position: Int) {
        holder.setdata(receiverModelList[position])

    }

    override fun getItemCount(): Int {
       return receiverModelList.size
    }


}