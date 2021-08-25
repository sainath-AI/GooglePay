package com.masai.sainath.gpay

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.sender_layout_item.view.*


class RecieverViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun setdata(receiverModel: ReceiverModel){
            itemView.apply {
                txtmessageSend.text=receiverModel.message
            }

    }

}