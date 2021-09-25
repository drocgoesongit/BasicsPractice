package com.example.happybirthday

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.example.happybirthday.Adapters.MainRecyclerViewAdapter
import java.sql.DriverManager.println

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "All Practiced Activities"

        // Initialization Of Views.

        val mainRecyclerView = findViewById<androidx.recyclerview.widget.RecyclerView>(R.id.recyclerViewMain)

        mainRecyclerView.adapter = MainRecyclerViewAdapter()
        mainRecyclerView.layoutManager = GridLayoutManager(this,2)

    }
}