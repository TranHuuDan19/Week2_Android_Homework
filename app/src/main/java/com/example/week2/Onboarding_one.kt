package com.example.week2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class Onboarding_one : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding_one)
        val btn = findViewById<ImageButton>(R.id.btn_next)
        btn.setOnClickListener {
            val intent = Intent(this,Onboarding_two::class.java)
            startActivity(intent)
        }
    }
}