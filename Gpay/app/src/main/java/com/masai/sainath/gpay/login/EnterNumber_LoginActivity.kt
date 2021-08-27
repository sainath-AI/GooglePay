package com.masai.sainath.gpay.login

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.view.View
import android.widget.PopupMenu
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import com.masai.sainath.gpay.R
import com.masai.sainath.gpay.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_enter_number_login.*

class EnterNumber_LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enter_number_login)

        menupop()
        editText()

        btnNextTo.setOnClickListener {
            val intent=Intent(applicationContext,GoogleAutho::class.java)
            intent.putExtra("number",etNumber.text.toString())
            startActivity(intent)
        }
    }


    private fun editText() {

        etNumber.doAfterTextChanged {
            if (etNumber.isInTouchMode) {
                val gradientDrawable = GradientDrawable()
                gradientDrawable.setStroke(5, Color.parseColor("#067DD6"))
                gradientDrawable.cornerRadius = 6F
                linearEnterNumber.setBackgroundDrawable(gradientDrawable)
            }
            if (etNumber.text.toString().trim().length == 10) {
                btnNextTo.visibility = View.VISIBLE
                val gd = GradientDrawable()
                gd.setColor(Color.parseColor("#067DD6"))
                gd.cornerRadius = 50F
                btnNextTo.setBackgroundDrawable(gd)
                btnNextTo.setTextColor(Color.WHITE)
            } else if (etNumber.text.toString().trim().length < 10) {
                btnNextTo.visibility = View.VISIBLE
                val gd = GradientDrawable()
                gd.setColor(Color.parseColor("#DDDCDC"))
                gd.cornerRadius = 50F
                btnNextTo.setBackgroundDrawable(gd)
                btnNextTo.setTextColor(Color.parseColor("#8A8A8A"))
            }
        }
    }

    private fun menupop() {
        loginMenu.setOnClickListener {
            val popupMenu = PopupMenu(applicationContext, loginMenu)
            popupMenu.menuInflater.inflate(R.menu.login_popmenu, popupMenu.menu)
            popupMenu.setOnMenuItemClickListener { menuItem -> // Toast message on menu item clicked
                Toast.makeText(
                    applicationContext,
                    "You Clicked " + menuItem.title,
                    Toast.LENGTH_SHORT
                ).show()
                true
            }
            popupMenu.show()
        }
    }
}