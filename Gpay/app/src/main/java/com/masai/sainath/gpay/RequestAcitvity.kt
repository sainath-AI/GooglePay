package com.masai.sainath.gpay

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_pay.*
import kotlinx.android.synthetic.main.activity_settings.*

class RequestAcitvity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_request_acitvity)
        Glide.with(ProfileImagee).load("https://firebasestorage.googleapis.com/v0/b/pay-464a4.appspot.com/o/a7.jpg?alt=media&token=a19902b9-4d45-45f5-a774-d0af617dfd2e")
            .into(ProfileImagee)
    }
}