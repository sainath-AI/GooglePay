package com.masai.sainath.gpay.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Toast
import androidx.core.widget.doAfterTextChanged
import com.masai.sainath.gpay.R
import kotlinx.android.synthetic.main.activity_otpactivity.*

class OTPActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_otpactivity)

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