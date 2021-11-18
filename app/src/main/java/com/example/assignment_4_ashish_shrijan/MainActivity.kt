package com.example.assignment_4_ashish_shrijan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun register_btn_click(v: View){
        if (v.id == R.id.register_btn){
            intent = Intent(this@MainActivity, RegisterActivity::class.java)
            startActivity(intent)
        }
    }

    fun login_btn_click(v: View){
        if (v.id == R.id.login_btn){
            intent = Intent(this@MainActivity, WelcomeActivity::class.java)
            startActivity(intent)
        }
    }
}