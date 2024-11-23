package com.example.cmsc436groupproject

import android.os.Bundle
import android.widget.RatingBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class GroupDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_group_detail)

        val ratingBar: RatingBar = findViewById(R.id.group_rating_bar)
        val ratingText: TextView = findViewById(R.id.rating_text)

        ratingBar.setOnRatingBarChangeListener { _, rating, _ ->
            ratingText.text = "You rated this group: $rating stars"
        }
    }
}
