package com.example.happybirthday.Model

import com.example.happybirthday.R

class DataSource {
    fun loadAffirmations(): List<Affirmation>{
        return listOf<Affirmation>(
            Affirmation(R.string.affirmation1, R.drawable.image1),
            Affirmation(R.string.affirmation2, R.drawable.image2),
            Affirmation(R.string.affirmation3, R.drawable.image3),
            Affirmation(R.string.affirmation4, R.drawable.image4),
            Affirmation(R.string.affirmation5, R.drawable.image5),
            Affirmation(R.string.affirmation6, R.drawable.image6),
            Affirmation(R.string.affirmation7, R.drawable.image7),
            Affirmation(R.string.affirmation8, R.drawable.image8),
            Affirmation(R.string.affirmation9, R.drawable.image9),
            Affirmation(R.string.affirmation10, R.drawable.image10)
        )
    }

    fun loadActivityName(): List<ActivityObject>{
        return listOf<ActivityObject>(
            ActivityObject("Tip Counter Activity", 1),
            ActivityObject("Dice With Java", 2),
            ActivityObject("Dice With Kotlin", 3),
            ActivityObject("Dish (Activity Lifecycle)", 4),
            ActivityObject("RecyclerView", 5),
            ActivityObject("Fragments", 6)
        )
    }
}