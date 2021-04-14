package com.example.week2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.databinding.adapters.ViewBindingAdapter
import androidx.lifecycle.ViewModelProvider
import com.example.week2.databinding.ActivityProfileBinding

class Profile : AppCompatActivity() {
    private lateinit var binding: ActivityProfileBinding
    private lateinit var viewModel: ProfileViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_profile)
        viewModel = ViewModelProvider(this).get(ProfileViewModel::class.java)
        binding.btnBack.setOnClickListener {
            viewModel.account.name = binding.edtFullName.editText.toString().trim()
            viewModel.account.email = binding.edtEmail.editText.toString().trim()
            viewModel.account.password = binding.edtPhone.toString().trim()
        }
    }

    fun DialogProfileF(TextviewDPF: TextView, title: String) {
        TextviewDPF.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            val inflater = layoutInflater
            val dialogLayout = inflater.inflate(R.layout.dialog_profile, null)
            val editTextProfile = dialogLayout.findViewById<TextView>(R.id.edit_userInformation)
            with(builder) {
                setTitle(title)
                setPositiveButton("Submit")
                { dialog, which_ ->
                    TextviewDPF.text = editTextProfile.text.toString()
                    Toast.makeText(this@Profile, "Successful!!!", Toast.LENGTH_SHORT).show()
                    dialog.dismiss()
                }
                setNegativeButton("Cancel")
                { dialog, which_ ->
                    Toast.makeText(this@Profile, "GoodBye", Toast.LENGTH_SHORT).show()
                    dialog.dismiss()
                }
                setView(dialogLayout)
                show()
            }
        }
    }
}