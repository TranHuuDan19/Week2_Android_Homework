package com.example.week2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.android.material.button.MaterialButton

class Welcome : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        val btn_Skip = findViewById<MaterialButton>(R.id.btn_skip)
        btn_Skip.setOnClickListener {
            val intent1 = Intent(this,SignIn::class.java)
            startActivity(intent1)
        }
        val btn_SignIn = findViewById<TextView>(R.id.tv_signIn)
        btn_SignIn.setOnClickListener {
            val intent = Intent(this,SignIn::class.java)
            startActivity(intent)
        }

        val btn_SignUp = findViewById<MaterialButton>(R.id.btn_start)
        btn_SignUp.setOnClickListener {
            val intent = Intent(this,SignUp::class.java)
            startActivity(intent)
        }
    }
}