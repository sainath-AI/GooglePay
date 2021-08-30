package com.masai.sainath.gpay.TrasactionHistory

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.transaction_item_layout.view.*

class TransationViewHolder(val view: View,val listener:clicklisten):RecyclerView.ViewHolder(view) {

    fun setdata(list:TransationModel){
        view.apply {
            Glide.with(context).load(list.Image).into(civtran)
            tvtran.text=list.username
            tvtran1.text=list.currentdate
            tvtran2.text=list.amount
            rlayout.setOnClickListener {
                listener.onClicked(adapterPosition,list)
            }
        }
    }
}