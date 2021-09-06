package com.example.happybirthday

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class DiceJava : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dice_java)
        val button = findViewById<Button>(R.id.button2)
        val image = findViewById<ImageView>(R.id.imageView2)
        supportActionBar!!.hide()
        button.setOnClickListener(View.OnClickListener {
            val dice = DiceClass()
            val number = dice.roll()
            image.setImageResource(R.drawable.d_one)
            if (number == 1) {
                image.setImageResource(R.drawable.d_one)
            } else if (number == 2) {
                image.setImageResource(R.drawable.d_two)
            } else if (number == 3) {
                image.setImageResource(R.drawable.d_three)
            } else if (number == 4) {
                image.setImageResource(R.drawable.d_four)
            } else if (number == 5) {
                image.setImageResource(R.drawable.d_five)
            } else if (number == 6) {
                image.setImageResource(R.drawable.d_six)
            } else {
                image.setImageResource(R.drawable.d_one)
            }
        })
    }
}