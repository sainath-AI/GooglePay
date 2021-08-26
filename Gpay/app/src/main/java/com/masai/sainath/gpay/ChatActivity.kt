package com.masai.sainath.gpay

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.masai.sainath.gpay.adapter_class.ChatAdapter
import com.masai.sainath.gpay.model_class.ReceiverModel
import kotlinx.android.synthetic.main.activity_chat.*
import java.util.ArrayList

class ChatActivity : AppCompatActivity() {

    private  val receiverModel: List<ReceiverModel> = ArrayList<ReceiverModel>()
    private var chatAdapter: ChatAdapter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        userNamee.text = intent.getStringExtra("name")
        Glide.with(ProfileImagee).load(intent.getStringExtra("image")).into(ProfileImagee)

        btnpay.setOnClickListener {
            val intent = Intent(this,PayActivity::class.java)
            startActivity(intent)
        }
        btnrequest.setOnClickListener {
            val intent = Intent(this,RequestAcitvity::class.java)
            startActivity(intent)
        }



        setrecyclerAdapter()
        buildChatList()
    }

    private fun buildChatList() {

        val receiverModel = ReceiverModel(editTextMessage.text.toString()!!)


    }

    private fun setrecyclerAdapter() {
        chatAdapter= ChatAdapter(receiverModel)
        val layoutManager=LinearLayoutManager(this)
        recyclerview.layoutManager=layoutManager
        recyclerview.adapter=chatAdapter

           }


}