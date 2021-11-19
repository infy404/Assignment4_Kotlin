package com.example.assignment_4_ashish_shrijan

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//Defining table name
@Entity(tableName = "customer")
data class CustomerModel(
    //Defining all the columns in the table
    @ColumnInfo(name = "userName") var userName : String,
    @ColumnInfo(name = "password") var password: String,
    @ColumnInfo(name = "firstName") var firstName: String,
    @ColumnInfo(name = "lastName") var lastName: String,
    @ColumnInfo(name = "address") var address: String,
    @ColumnInfo(name = "city") var city : String,
    @ColumnInfo(name = "postalCode") var postalCode: String,
    @ColumnInfo(name = "telephone") var telephone: String,
    @ColumnInfo(name = "email") var email: String

){
    //Defining the primary key.
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "customerId") var customerId: Int? = null
}
