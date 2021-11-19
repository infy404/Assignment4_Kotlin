package com.example.assignment_4_ashish_shrijan

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [CustomerModel::class], version = 1, exportSchema = false)
abstract class CustomerDatabase: RoomDatabase() {

    abstract fun customerDao(): CustomerDao

    companion object{
        @Volatile
        private var INSTANCE: CustomerDatabase? = null

        fun getDatabaseCus(context: Context) : CustomerDatabase {

            if(INSTANCE != null ) return INSTANCE!!

             synchronized(this){
                 INSTANCE = Room.databaseBuilder(context, CustomerDatabase::class.java, "CUSTOMERDB")
                     .fallbackToDestructiveMigration()
                     .build()

                 return INSTANCE!!
             }
        }
    }
}