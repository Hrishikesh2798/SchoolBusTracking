package com.ctlb.schoolbustracking

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_login.password
import kotlinx.android.synthetic.main.activity_login.phoneNumber
import kotlinx.android.synthetic.main.activity_login.signUpButton
import kotlinx.android.synthetic.main.activity_login.registryType

class LogInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val typeAdapter: ArrayAdapter<String>
        val types = arrayOf("Organisation", "Driver", "Parent/Student")

        typeAdapter = ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item, types)
        registryType.adapter = typeAdapter

        registryType.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
                setContentView(R.layout.activity_login)
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                if (position == 3) {
                    setContentView(R.layout.activity_login)
                }
            }
        }

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