package com.masai.sainath.gpay.login

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.PopupMenu
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import com.google.firebase.auth.PhoneAuthProvider.ForceResendingToken
import com.google.firebase.auth.PhoneAuthProvider.OnVerificationStateChangedCallbacks
import com.masai.sainath.gpay.R
import com.masai.sainath.gpay.databinding.ActivityGoogleAuthoBinding
import kotlinx.android.synthetic.main.activity_enter_number_login.view.*
import kotlinx.android.synthetic.main.activity_google_autho.*
import java.util.concurrent.TimeUnit

class GoogleAutho : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       setContentView(R.layout.activity_google_autho)


        val number:String=intent.getStringExtra("number")!!
        //val progressBar = findViewById<ProgressBar>(R.id.progressbar_sending_otp)

        btnNextToOTP.setOnClickListener(View.OnClickListener {
            if (!number.isEmpty()) {
                if (number.length == 10) {
//                    progressBar.visibility = View.VISIBLE
                    btnNextToOTP.setVisibility(View.INVISIBLE)
                    PhoneAuthProvider.getInstance().verifyPhoneNumber(
                        "+91" + number,
                        60,
                        TimeUnit.SECONDS,
                        this,
                        object : OnVerificationStateChangedCallbacks() {
                            override fun onVerificationCompleted(phoneAuthCredential: PhoneAuthCredential) {
//                                progressBar.visibility = View.GONE
                                btnNextToOTP.setVisibility(View.VISIBLE)
                            }

                            override fun onVerificationFailed(e: FirebaseException) {
//                                progressBar.visibility = View.GONE
                                btnNextToOTP.setVisibility(View.VISIBLE)
                                Toast.makeText(
                                    applicationContext,
                                    e.message,
                                    Toast.LENGTH_SHORT
                                ).show()
                            }

                            override fun onCodeSent(
                                backendotp: String,
                                forceResendingToken: ForceResendingToken
                            ) {
//                                progressBar.visibility = View.GONE
                                btnNextToOTP.setVisibility(View.VISIBLE)
                                val intent =
                                    Intent(applicationContext, OTPActivity::class.java)
                                intent.putExtra("mobile", number)
                                intent.putExtra("backendotp", backendotp)
                                startActivity(intent)
                            }
                        }
                    )

                    //                        Intent intent = new Intent(getApplicationContext(),verifyenterotptwo.class);
                    //                        intent.putExtra("mobile",enternumber.getText().toString());
                    //                        startActivity(intent);
                } else {
                    Toast.makeText(
                        this,
                        "Please enter correct number",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            } else {
                Toast.makeText(applicationContext, "Enter Mobile number", Toast.LENGTH_SHORT)
                    .show()
            }
        })

    }

}