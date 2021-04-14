package com.example.week2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.week2.databinding.ActivitySignInBinding
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class SignIn : AppCompatActivity() {
    private lateinit var binding: ActivitySignInBinding
    private lateinit var viewModel: SigninViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_sign_in)
        viewModel= ViewModelProvider(this).get(SigninViewModel::class.java)
                binding.btnSignin.setOnClickListener {
                    viewModel.account.email=binding.edtEmail.editText.toString().trim()
                    viewModel.account.password=binding.edtPassword.toString().trim()
                val intent = Intent(this@SignIn, Profile::class.java)
                startActivity(intent)
            }
        }
    }