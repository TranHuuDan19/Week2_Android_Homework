package com.example.week2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.week2.databinding.ActivitySignUpBinding

class SignUp : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    private lateinit var viewModel: SignupViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sign_up)
        viewModel = ViewModelProvider(this).get(SignupViewModel::class.java)
        binding.btnSignUp.setOnClickListener {
            viewModel.account.name = binding.edtFullName.editText.toString().trim()
            viewModel.account.email = binding.edtEmail.editText.toString().trim()
            viewModel.account.password = binding.edtPassword.toString().trim()
            DataStore.name = viewModel.account.name
            DataStore.email = viewModel.account.email
            DataStore.password = viewModel.account.password
            binding.tvEmail.text = viewModel.account.email
            val intent = Intent(this@SignUp, SignIn::class.java)
            startActivity(intent)
        }
    }
}