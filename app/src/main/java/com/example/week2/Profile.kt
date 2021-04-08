package com.example.week2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class Profile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        val TextView_Email =findViewById<TextView>(R.id.edt_email_input)
        val TextView_Fullname= findViewById<TextView>(R.id.edt_full_name_input)
        val TextView_Phone=findViewById<TextView>(R.id.edt_phone_input)

        val bundle =intent.extras
        bundle?.let{
            val userInformation =bundle.getParcelable<UserInformationData>("userInformation")
            TextView_Email.text   = String.format("%S",userInformation?.email)
            TextView_Fullname.text= String.format("%S",userInformation?.fullName)
            TextView_Phone.text   = String.format("%S",userInformation?.phoneNumber)
        }
            DialogProfileF(TextView_Fullname, "Name")
            DialogProfileF(TextView_Phone, "Phone Number")
            DialogProfileF(TextView_Email,"Email")
    }
    fun DialogProfileF(TextviewDPF: TextView, title:String)
    {
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