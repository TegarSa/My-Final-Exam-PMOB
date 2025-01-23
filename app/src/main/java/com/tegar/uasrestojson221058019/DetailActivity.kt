package com.tegar.uasrestojson221058019

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val mealName = intent.getStringExtra("mealName")
        val mealCategory = intent.getStringExtra("mealCategory")
        val mealImage = intent.getStringExtra("mealImage")
        val mealDescription = intent.getStringExtra("mealDescription")

        val textMealName: TextView = findViewById(R.id.textMealNameDetail)
        val textMealCategory: TextView = findViewById(R.id.textMealCategoryDetail)
        val textMealDescription: TextView = findViewById(R.id.textMealDescriptionDetail)
        val imageMeal: ImageView = findViewById(R.id.imageMealDetail)

        textMealName.text = mealName
        textMealCategory.text = mealCategory
        textMealDescription.text = mealDescription
        Glide.with(this).load(mealImage).into(imageMeal)
    }
}
