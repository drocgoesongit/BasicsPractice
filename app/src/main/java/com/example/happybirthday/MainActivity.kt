package com.example.happybirthday

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import java.sql.DriverManager.println

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        val TAG = "tag"
        val happyText = findViewById<TextView>(R.id.happyBirthdayText)
        val image = findViewById<ImageView>(R.id.image)
        image.setOnClickListener(View.OnClickListener {
            val numberRange = 1..6
            val number = numberRange.random()
            Log.i(TAG, number.toString())
            intent = Intent(this, DiceClass::class.java)
            startActivity(intent)
        })
        happyText.setOnClickListener{
            intent = Intent(this,TipCounterActivity::class.java)
            startActivity(intent)
        }

    }
}