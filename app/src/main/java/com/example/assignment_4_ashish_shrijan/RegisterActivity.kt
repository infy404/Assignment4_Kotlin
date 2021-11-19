package com.example.assignment_4_ashish_shrijan

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telecom.TelecomManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import java.net.Inet4Address

class RegisterActivity : AppCompatActivity() {

    lateinit var customerViewModel: CustomerViewModel
    lateinit var context: Context
    lateinit var userName: String
    lateinit var password: String
    lateinit var firstName: String
    lateinit var lastName: String
    lateinit var address: String
    lateinit var city: String
    lateinit var postalCode: String
    lateinit var telephone: String
    lateinit var email: String




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        context = this@RegisterActivity

        customerViewModel = ViewModelProvider(this).get(CustomerViewModel::class.java)

        //defining reference object for UI controls
        var btnRegister : Button = findViewById(R.id.rRegister_btn)
        var editUserName: EditText = findViewById(R.id.userName_ET)
        var editPassword: EditText = findViewById(R.id.password_ET)
        var editFirstName: EditText = findViewById(R.id.firstName_ET)
        var editLastName: EditText = findViewById(R.id.lastName_ET)
        var editAddress: EditText = findViewById(R.id.address_ET)
        var editCity: EditText = findViewById(R.id.city_ET)
        var editPostalCode: EditText = findViewById(R.id.postalCode_ET)
        var editTelephone: EditText = findViewById(R.id.telephone_ET)
        var editEmail: EditText = findViewById(R.id.email_ET)

        btnRegister.setOnClickListener{
            userName = editUserName.toString().trim()
            password = editPassword.toString().trim()
            firstName = editFirstName.toString().trim()
            lastName = editLastName.toString().trim()
            address = editAddress.toString().trim()
            city = editCity.toString().trim()
            postalCode = editPostalCode.toString().trim()
            telephone = editTelephone.toString().trim()
            email = editEmail.toString().trim()

            if (userName.isEmpty() || password.isEmpty() || firstName.isEmpty() || lastName.isEmpty() || address.isEmpty()
                || city.isEmpty() || postalCode.isEmpty() || telephone.isEmpty() || email.isEmpty()){
                Toast.makeText(context, "Please input all the fields!!", Toast.LENGTH_LONG).show()
            }
            else{
                customerViewModel.insertCustomer(context, userName, password, firstName, lastName, address, city,postalCode, telephone, email)
            }
        }





    }
}