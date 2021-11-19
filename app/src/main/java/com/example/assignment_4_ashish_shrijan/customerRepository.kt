package com.example.assignment_4_ashish_shrijan

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.assignment_4_ashish_shrijan.CustomerDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class customerRepository() {

    companion object {
        var customerDatabase: CustomerDatabase? = null
        var customerModel: LiveData<CustomerModel>? = null

        //initialize database
        fun initializeDB(context: Context): CustomerDatabase {
            return CustomerDatabase.getDatabaseCus(context)
        }

        //Initialize insertCustomer()
        fun insertCustomer(
            context: Context, userName: String,
            password: String, firstName: String, lastName: String,
            address: String, city: String, postalCode: String,
            telephone: String, email: String
        ) {
            customerDatabase = initializeDB(context)

            CoroutineScope(IO).launch {
                val customerDetails = CustomerModel(
                    userName, password,
                    firstName, lastName, address, city, postalCode, telephone, email
                )
                customerDatabase!!.customerDao().addCustomer(customerDetails)
            }

        }

        fun getCustomerDetails(context: Context, firstName: String) : LiveData<CustomerModel>{
            customerDatabase = initializeDB(context)
            customerModel = customerDatabase!!.customerDao().getCustomer(firstName)
            return customerModel!!
        }

        fun getLoginDetails(
            context: Context,
            userName: String,
            password: String
        ): LiveData<CustomerModel>? {
            customerDatabase = initializeDB(context)
            customerModel = customerDatabase!!.customerDao().getLoginDetails(userName, password)
            return customerModel
        }
    }
}


