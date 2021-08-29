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

class PayActivity : AppCompatActivity() {

    private lateinit var databaseReferenc:DatabaseReference
    private lateinit var databaseTracsact:DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pay)


        var usernamee:String = intent.getStringExtra("username")
        userName.text = usernamee
        Glide.with(ProfileImage).load("https://firebasestorage.googleapis.com/v0/b/pay-464a4.appspot.com/o/a7.jpg?alt=media&token=a19902b9-4d45-45f5-a774-d0af617dfd2e")
            .into(ProfileImage)
//        Toast.makeText(applicationContext,intent.getStringExtra("username"),Toast.LENGTH_SHORT).show()
        databaseReferenc=FirebaseDatabase.getInstance()
            .getReference("Peoples/${intent.getStringExtra("username")}")

        databaseReferenc.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {

//                var imageStr: String = snapshot.child("naam1").getValue().toString()
//                userName.text = imageStr
//                if(snapshot.exists()){
//                    var usernamee:String = intent.getStringExtra("username")
//                    userName.text = usernamee
//                    var imageStr: String = snapshot.child("Image").getValue().toString()
//                    Glide.with(ProfileImage).load(imageStr).into(ProfileImage)
//
//                    val sdf = SimpleDateFormat("dd:MM:yyyy_hh:mm:ss")
//                    val currentDate = sdf.format(Date())
//
//                    floatingButton.setOnClickListener {
//                        databaseTracsact  = FirebaseDatabase.getInstance().getReference("Transaction")
//                           databaseTracsact.child("$currentDate")
//                            .child("username").setValue("$usernamee")
//                        databaseTracsact.child("$currentDate")
//                            .child("currentdate").setValue("$currentDate")
//                        databaseTracsact.child("$currentDate")
//                            .child("amount").setValue("${etRupees.text.toString()}")
//                    }
//                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }
}