package com.example.assignment_4_ashish_shrijan

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CustomerDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addCustomer(customer: CustomerModel)

    @Query("SELECT * FROM customer WHERE userName =:userName AND password=:password ORDER BY customerId ASC")
    fun getLoginDetails(userName: String, password: String): LiveData<CustomerModel>

    @Query("SELECT * FROM customer WHERE userName =:userName")
    fun getCustomer(userName: String) : LiveData<CustomerModel>

}