package com.masai.sainath.gpay.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Toast
import androidx.core.widget.doAfterTextChanged
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.FirebaseException
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthProvider
import com.google.firebase.auth.PhoneAuthProvider.ForceResendingToken
import com.google.firebase.auth.PhoneAuthProvider.OnVerificationStateChangedCallbacks
import com.masai.sainath.gpay.MainActivity
import com.masai.sainath.gpay.R
import kotlinx.android.synthetic.main.activity_otpactivity.*
import java.util.concurrent.TimeUnit

class OTPActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_otpactivity)

        otpToMove()
        var getotpbackend = intent.getStringExtra("backendotp")
        verifyOTP.setOnClickListener(View.OnClickListener {
            if (!otpET1.getText().toString().trim { it <= ' ' }
                    .isEmpty() && !otpET2.getText().toString().trim { it <= ' ' }
                    .isEmpty() && !otpET3.getText().toString().trim { it <= ' ' }
                    .isEmpty() && !otpET4.getText().toString().trim { it <= ' ' }
                    .isEmpty()) {
                val entercodeotp: String = otpET1.getText().toString() +
                        otpET2.getText().toString() +
                        otpET3.getText().toString() +
                        otpET4.getText().toString() +
                        otpET5.getText().toString() +
                        otpET6.getText().toString()
                if (getotpbackend != null) {
//                    progressBarverifyotp.setVisibility(View.VISIBLE)
//                    verifybuttonclick.setVisibility(View.INVISIBLE)
                    val phoneAuthCredential = PhoneAuthProvider.getCredential(
                        getotpbackend!!, entercodeotp
                    )
                    FirebaseAuth.getInstance().signInWithCredential(phoneAuthCredential)
                        .addOnCompleteListener { task ->
//                            progressBarverifyotp.setVisibility(View.GONE)
//                            verifybuttonclick.setVisibility(View.VISIBLE)
                            if (task.isSuccessful) {
                                val intent = Intent(applicationContext, MainActivity::class.java)
                                intent.flags =
                                    Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                                startActivity(intent)
                            } else {
                                Toast.makeText(
                                    applicationContext,
                                    "Enter the correct Otp",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                } else {
                    Toast.makeText(
                        applicationContext,
                        "Please check internet connection",
                        Toast.LENGTH_SHORT
                    ).show()
                }

//                    Toast.makeText(verifyenterotptwo.this,"otp verify",Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(
                    applicationContext,
                    "please enter all number",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })


        resendOtp.setOnClickListener(View.OnClickListener {
            PhoneAuthProvider.getInstance().verifyPhoneNumber(
                "+91" + intent.getStringExtra("mobile"),
                60,
                TimeUnit.SECONDS,
                this,
                object : OnVerificationStateChangedCallbacks() {
                    override fun onVerificationCompleted(phoneAuthCredential: PhoneAuthCredential) {}
                    override fun onVerificationFailed(e: FirebaseException) {
                        Toast.makeText(applicationContext, e.message, Toast.LENGTH_SHORT).show()
                    }

                    override fun onCodeSent(
                        newbackendotp: String,
                        forceResendingToken: ForceResendingToken
                    ) {
                        getotpbackend = newbackendotp
                        Toast.makeText(
                            applicationContext,
                            "Otp sended Succussfully",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            )
        })



    }

    private fun otpToMove() {
        otpET1.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (otpET1.text.toString().length == 1) {
                    otpET1.clearFocus()
                    otpET2.requestFocus()
                    otpET2.setCursorVisible(true)
                }
            }

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

            }

            override fun afterTextChanged(s: Editable) {
                if (otpET1.text.toString().length == 0) {
                    otpET1.requestFocus()
                    verifyOTP.visibility = View.GONE
                }
            }
        })


        otpET2.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (otpET2.text.toString().length == 1) {
                    otpET2.clearFocus()
                    otpET3.requestFocus()
                    otpET3.setCursorVisible(true)

                }
            }

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
            }

            override fun afterTextChanged(s: Editable) {
                if (otpET2.text.toString().length == 0) {
                    otpET1.requestFocus()
                    verifyOTP.visibility = View.GONE
                }

            }
        })

        otpET3.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (otpET3.text.toString().length == 1) {
                    otpET3.clearFocus()
                    otpET4.requestFocus()
                    otpET4.setCursorVisible(true)
                }
            }

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
            }

            override fun afterTextChanged(s: Editable) {
                if (otpET3.text.toString().length == 0) {
                    otpET2.requestFocus()
                    verifyOTP.visibility = View.GONE
                }

            }
        })

        otpET4.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (otpET4.text.toString().length == 1) {
                    otpET4.clearFocus()
                    otpET5.requestFocus()
                    otpET5.setCursorVisible(true)
                }
            }

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
            }

            override fun afterTextChanged(s: Editable) {
                if (otpET4.text.toString().length == 0) {
                    otpET3.requestFocus()
                    verifyOTP.visibility = View.GONE
                }
            }
        })

        otpET5.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (otpET5.text.toString().length == 1) {
                    otpET5.clearFocus()
                    otpET6.requestFocus()
                    otpET6.setCursorVisible(true)
                }
            }

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
            }

            override fun afterTextChanged(s: Editable) {
                if (otpET5.text.toString().length == 0) {
                    otpET4.requestFocus()
                    verifyOTP.visibility = View.GONE
                }
            }
        })


        otpET6.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (otpET6.text.toString().length == 1) {
                    otpET6.requestFocus()
                    otpET6.setCursorVisible(true)

                }
            }

            override fun afterTextChanged(s: Editable?) {
                if (otpET6.text.toString().length == 0) {
                    otpET5.requestFocus()
                    verifyOTP.visibility = View.GONE
                }
            }
        })


        otpET6.doAfterTextChanged {
            var otpString:String = otpET1.text.toString()+ otpET2.text.toString()+ otpET3.text.toString()+ otpET4.text.toString()+ otpET5.text.toString()+ otpET6.text.toString()

            if(otpString.length>5){
                verifyOTP.visibility = View.VISIBLE

            }

//            Toast.makeText(applicationContext,otpString,Toast.LENGTH_SHORT).show()
        }
    }
}