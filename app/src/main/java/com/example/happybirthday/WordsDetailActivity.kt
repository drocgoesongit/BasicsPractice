package com.example.happybirthday

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.happybirthday.Adapters.AdapterForWordsList

class WordsDetailActivity : AppCompatActivity() {

    companion object{
        const val LETTER = "letter"
        const val SEARCH_PREFIX = "https://www.google.com/search?q="
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_words_detail)

        val recyclerView = findViewById<RecyclerView>(R.id.for_words_recyclerView)

        val letterClicked = intent?.extras?.getString(LETTER).toString()
        Toast.makeText(this, letterClicked, Toast.LENGTH_SHORT).show()

        //Changing the title of the activity.
        title = getString(R.string.detail_title) + letterClicked

        recyclerView.adapter = AdapterForWordsList(this,letterClicked)
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}