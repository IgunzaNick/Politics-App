package com.example.ngogoyo.ui.Views



import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler


class NgogoyoSplash : AppCompatActivity() {
    lateinit var handler: Handler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar!!.hide()
        Handler().postDelayed({
                              val intent = Intent(this,NoInternet::class.java)
            startActivity(intent)
            finish()

        },3000)
       


    }
}

