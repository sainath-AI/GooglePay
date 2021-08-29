package com.masai.sainath.poetry

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SpalshScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spalsh_screen)

       Handler().postDelayed(Runnable {
           startActivity(Intent(this,StartActivity::class.java))
           finish()
       },3000)


    }
}


