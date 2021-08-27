package com.masai.sainath.gpay

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.masai.sainath.gpay.adapter_class.ChatAdapter
import com.masai.sainath.gpay.model_class.ReceiverModel
import kotlinx.android.synthetic.main.activity_chat.*
import java.util.*

class ChatActivity : AppCompatActivity() {

    private var receiverModelList: ArrayList<ReceiverModel> = ArrayList()
    private var chatAdapter: ChatAdapter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        userNamee.text = intent.getStringExtra("name")
        Glide.with(ProfileImagee).load(intent.getStringExtra("image")).into(ProfileImagee)

        btnpay.setOnClickListener {
            val intent = Intent(this, PayActivity::class.java)
            startActivity(intent)
        }
        btnrequest.setOnClickListener {
            val intent = Intent(this, RequestAcitvity::class.java)
            startActivity(intent)
        }
        buildChatList()
        setrecyclerAdapter()
        textChange()
    }

    private fun textChange() {
        editTextMessage.doAfterTextChanged {
            if (editTextMessage.text.toString().trim().length > 0) {
                sendChat.visibility = View.VISIBLE
                editTextMessage.width
                btnpay.visibility = View.GONE
                btnrequest.visibility = View.GONE
            } else {
                sendChat.visibility = View.GONE
                btnpay.visibility = View.VISIBLE
                btnrequest.visibility = View.VISIBLE
            }
        }
    }

    private fun buildChatList() {

        sendChat.setOnClickListener {
            val receiverModel = ReceiverModel(editTextMessage.text.toString()!!)
            receiverModelList.add(receiverModel)
            editTextMessage.text = null
            chatAdapter?.updateData(receiverModelList)
        }


    }

    private fun setrecyclerAdapter() {
        chatAdapter = ChatAdapter(receiverModelList)
        val layoutManager = LinearLayoutManager(this)
        recyclerview.layoutManager = layoutManager
        recyclerview.adapter = chatAdapter

    }


}