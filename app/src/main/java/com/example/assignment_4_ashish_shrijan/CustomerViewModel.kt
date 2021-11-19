package com.example.assignment_4_ashish_shrijan

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel


class CustomerViewModel: ViewModel() {

    var liveCustomerData: LiveData<CustomerModel>? = null

    fun insertCustomer(context: Context, userName: String, password: String, firstName: String, lastName: String,
                       address: String, city: String, postalCode: String,
                       telephone: String, email: String){
        customerRepository.insertCustomer(context, userName, password,
            firstName, lastName, address, city, postalCode, telephone, email)
    }

    fun getCustomer(context: Context, userName: String, password: String, firstName: String, lastName: String,
                    address: String, city: String, postalCode: String,
                    telephone: String, email: String) : LiveData<CustomerModel>{
        liveCustomerData = customerRepository.getCustomerDetails(context, userName)
        return liveCustomerData!!

    }

    fun getLogin(context: Context, userName: String, password: String) : LiveData<CustomerModel>{
        liveCustomerData = customerRepository.getLoginDetails(context, userName, password)
        return liveCustomerData!!
    }

}