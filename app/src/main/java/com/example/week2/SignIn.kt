package com.example.week2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class SignIn : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        val email_signin = findViewById<EditText>(R.id.tv_email)
        val pass_signin  = findViewById<EditText>(R.id.tv_pass)
        val btn_login    = findViewById<MaterialButton>(R.id.btn_signin)

        btn_login.setOnClickListener {

            if (email_signin.text.toString().compareTo("ronaldo@gmail.com") == 0 && pass_signin.text.toString().compareTo("123456") == 0) {
                val intent = Intent(this, Profile::class.java)
                startActivity(intent)
            }
            else
                Toast.makeText(this,"Your Email or Password Is Not Correct!",Toast.LENGTH_LONG).show()

        }
    }
}