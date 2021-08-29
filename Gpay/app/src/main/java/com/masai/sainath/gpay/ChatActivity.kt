package com.masai.sainath.gpay

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.google.firebase.database.*
import com.masai.sainath.gpay.adapter_class.ChatAdapter
import com.masai.sainath.gpay.model_class.ReceiverModel
import kotlinx.android.synthetic.main.activity_chat.*
import java.text.SimpleDateFormat
import java.util.*

class ChatActivity : AppCompatActivity() {

    private var receiverModelList: ArrayList<ReceiverModel> = ArrayList()
    private var chatAdapter: ChatAdapter? = null

    private lateinit var database1: DatabaseReference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)
//        database1 = Firebase.database.reference

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

        setRecyclerAdapter()
        textChange()


        sendChat.setOnClickListener {
            val sdf = SimpleDateFormat("dd:M:yyyy_hh:mm:ss")
            val currentDate = sdf.format(Date())
            database1
//                .child("chat")
                .child("$currentDate")
                .child("chat")
//                .child("chat")
                .setValue("${editTextMessage.text.toString()}")

//            val receiverModel = ReceiverModel(editTextMessage.text.toString()!!)
//            receiverModelList.add(receiverModel)
            editTextMessage.text = null


//
        }
//

        buildChatList()

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


        receiverModelList.clear()
        database1 =
            FirebaseDatabase.getInstance().getReference("chat/${intent.getStringExtra("name")}")
//            .child("${intent.getStringExtra("name")}")
        database1.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                receiverModelList.clear()
                if (snapshot.exists()) {
                    for (usersnapshot in snapshot.children) {
                        val chat = usersnapshot.getValue(ReceiverModel::class.java)
                        receiverModelList.add(chat!!)
//                        chatAdapter?.updateData(receiverModelList)
                    }
                    recyclerview.adapter = ChatAdapter(receiverModelList)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })


    }

    private fun setRecyclerAdapter() {
//        chatAdapter = ChatAdapter(receiverModelList)
        val layoutManager = LinearLayoutManager(this)
        recyclerview.layoutManager = layoutManager
        recyclerview.adapter = chatAdapter

    }


}