package com.ctlb.schoolbustracking


import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.core.view.marginTop
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_signup.*
import kotlinx.android.synthetic.main.activity_signup.signUpButton

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        val typeAdapter: ArrayAdapter<String>
        val types = arrayOf("Organisation", "Driver", "Parent/Student")

        typeAdapter = ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item, types)
        registryType.adapter = typeAdapter

        registryType.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
                setContentView(R.layout.activity_signup)
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val  param = signUpButton.layoutParams as ViewGroup.MarginLayoutParams
                param.topMargin = 1250
                signUpButton.layoutParams = param
                if(position == 0)
                {
                    regCode.visibility = View.VISIBLE
                    name.visibility = View.INVISIBLE
                }
                if(position == 1 || position == 2)
                {
                    name.visibility = View.VISIBLE
                    regCode.visibility = View.INVISIBLE
                }
            }
        }



    }
}

