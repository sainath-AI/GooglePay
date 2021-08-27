package com.masai.sainath.gpay

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.masai.sainath.gpay.login.EnterNumber_LoginActivity
import com.google.firebase.auth.FirebaseAuth

import com.google.firebase.auth.FirebaseUser





class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)


        Handler().postDelayed(Runnable {

            val user = FirebaseAuth.getInstance().currentUser
            if (user != null) {
                // User is signed in
                val i = Intent(this, MainActivity::class.java)
                i.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(i)
            } else {
                // User is signed out
                val i = Intent(this, EnterNumber_LoginActivity::class.java)
                startActivity(i)
            }

            finish()
        }, 3000)
    }
}