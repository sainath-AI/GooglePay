package com.masai.sainath.gpay

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.google.firebase.database.*
import com.masai.sainath.gpay.adapter_class.NewAdapter
import com.masai.sainath.gpay.model_class.Newmodel
import kotlinx.android.synthetic.main.activity_pay.*
import java.text.SimpleDateFormat
import java.util.*
import com.google.firebase.database.DatabaseError

import com.google.firebase.database.DataSnapshot

import com.google.firebase.database.ChildEventListener

import com.google.firebase.database.FirebaseDatabase
import com.masai.sainath.gpay.model_class.Model
import com.masai.sainath.gpay.model_class.Transact


class PayActivity : AppCompatActivity() {

    private lateinit var databaseReferenc:DatabaseReference
    private lateinit var databaseTracsact:DatabaseReference
    private lateinit var databaseTracsactchat:DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pay)

        databaseReferenc=FirebaseDatabase.getInstance()
            .getReference("main_database/Peoples").child("${intent.getStringExtra("username")}")

       lateinit var usernamee:String
       lateinit var imageStr:String
        databaseReferenc.addValueEventListener(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {

//                var imageStr: String = snapshot.child("naam1").getValue().toString()
//                userName.text = imageStr
                if(snapshot.exists()){
                    usernamee = snapshot.child("naam1").value.toString()
                    userName.text = usernamee
                    imageStr = snapshot.child("Image").value.toString()
                    Glide.with(ProfileImage).load(imageStr).into(ProfileImage)

                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })

        val sdf = SimpleDateFormat("dd:M:yyyy_hh:mm:ss")
        val currentDate = sdf.format(Date())

        val dsd =SimpleDateFormat("dd-M-yyyy, hh:mm a")
        val dates = dsd.format(Date())
        floatingButtonn.setOnClickListener {
            databaseTracsact = FirebaseDatabase.getInstance().getReference("Transactions").child("$currentDate")
            databaseTracsact.child("username").setValue("$usernamee")
            databaseTracsact.child("currentdate").setValue("$dates")
            databaseTracsact.child("amount").setValue("- Rs.${etRupees.text.toString()}")
            databaseTracsact.child("Image").setValue("$imageStr")
            Toast.makeText(applicationContext,"added to transaction",Toast.LENGTH_SHORT).show()

            databaseTracsactchat = FirebaseDatabase.getInstance().getReference("chat/$usernamee")
            databaseTracsactchat.child("$currentDate")
                .child("chat")
                .setValue("${etRupees.text.toString()} Rs. pay to $usernamee")
        }
    }
}