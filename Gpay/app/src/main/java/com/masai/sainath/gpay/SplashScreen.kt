package com.masai.sainath.gpay

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.masai.sainath.gpay.login.EnterNumber_LoginActivity


class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)


        Handler().postDelayed(Runnable {
            val i = Intent(
                this,
                EnterNumber_LoginActivity::class.java
            )
            startActivity(i)
            finish()
        }, 3000)
    }
}