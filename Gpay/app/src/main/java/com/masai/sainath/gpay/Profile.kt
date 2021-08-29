package com.masai.sainath.gpay

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.masai.sainath.gpay.login.GoogleAutho
import kotlinx.android.synthetic.main.activity_settings.*

class Profile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        bank.setOnClickListener {
            val intent=Intent(this, BankAccount::class.java)
             startActivity(intent)

        }


    }
}