package com.ctlb.schoolbustracking

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class LogInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginButton.setOnClickListener {
            val phone: String = phoneNumber.text.toString()
            val pwd: String = password.text.toString()
            Log.i("MainActivity",pwd)
            Toast.makeText(this,phone,Toast.LENGTH_LONG).show()
        }

        signUpButton.setOnClickListener {
            Toast.makeText(this,"Sign Up Button Clicked",Toast.LENGTH_SHORT).show()

            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
    }
}