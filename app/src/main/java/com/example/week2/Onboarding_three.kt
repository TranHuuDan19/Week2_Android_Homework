package com.example.week2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class Onboarding_three : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding_three)
        val btn3 = findViewById<ImageButton>(R.id.btn_next3)
        btn3.setOnClickListener {
            val intent = Intent(this,Welcome::class.java)
            startActivity(intent)
        }
    }
}