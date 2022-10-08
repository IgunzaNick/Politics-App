package com.example.ngogoyo.ui.Views

import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkCapabilities.NET_CAPABILITY_INTERNET
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.VISIBLE
import android.widget.Button
import android.widget.RelativeLayout
import androidx.annotation.RequiresApi
import com.example.ngogoyo.R

class NoInternet : AppCompatActivity() {
    private lateinit var noInternetLayout: RelativeLayout
    private lateinit var tryagainButton: Button
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_no_internet)
        supportActionBar!!.hide()
        noInternetLayout = findViewById(R.id.nointernetlayout)
        tryagainButton = findViewById(R.id.tryagainbutton)
        activityhappens()
        tryagainButton.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()

        }
    }
    @RequiresApi(Build.VERSION_CODES.M)
    private fun isNetworkAvailable(): Boolean{
        val cm = getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
        val capabilities = cm.getNetworkCapabilities(cm.activeNetwork)

        return (capabilities !=null && capabilities.hasCapability(NET_CAPABILITY_INTERNET))
    }
    @RequiresApi(Build.VERSION_CODES.M)
    private fun activityhappens(){
        if (isNetworkAvailable()){
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()

        }else{
            noInternetLayout.visibility = VISIBLE


        }
    }
}