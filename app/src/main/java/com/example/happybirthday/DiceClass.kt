package com.example.happybirthday

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast

class DiceClass : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dice_class)
        val button = findViewById<Button>(R.id.button)
        val image : ImageView = findViewById(R.id.diceImageView)
        val buttonIntent = findViewById<Button>(R.id.intentButton)
        supportActionBar?.hide()

        button.setOnClickListener(View.OnClickListener {
            val number = roll()
            if (number == 1) {
                image.setImageResource(R.drawable.d_one)
            } else if (number == 2) {
                image.setImageResource(R.drawable.d_two)
            } else if (number == 3) {
                image.setImageResource(R.drawable.d_three)
            } else if (number == 4) {
                image.setImageResource(R.drawable.d_four)
            } else if (number == 5) {
                image.setImageResource(R.drawable.d_one)
            } else {
                image.setImageResource(R.drawable.d_five)
            }

        })
        buttonIntent.setOnClickListener{
            intent = Intent(this,DiceJava::class.java)
            startActivity(intent)
        }


    }
    // roll function
    fun roll(): Int {
        return (1..6).random()
    }
}