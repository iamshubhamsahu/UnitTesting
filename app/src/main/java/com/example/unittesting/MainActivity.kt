package com.example.unittesting

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText

class MainActivity : AppCompatActivity() {

    private lateinit var eTUserName: AppCompatEditText
    private lateinit var eTEmail: AppCompatEditText
    private lateinit var eTPasword: AppCompatEditText
    private lateinit var btnSubmit: AppCompatButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        eTUserName = findViewById(R.id.eTUserName)
        eTEmail = findViewById(R.id.eTEmail)
        eTPasword = findViewById(R.id.eTPasword)
        btnSubmit = findViewById(R.id.btnSubmit)


        btnSubmit.setOnClickListener {

            val userName = eTUserName.text.toString()
            val email = eTEmail.text.toString()
            val password = eTPasword.text.toString()

            val validationResult = Validator.validate(userName, email, password)

            if (validationResult == null) {
                showToast("Validation successful!")
                /*intent = Intent(applicationContext, RegisterActivity::class.java)
                startActivity(intent)*/
            } else {
                showToast(validationResult)
            }
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}