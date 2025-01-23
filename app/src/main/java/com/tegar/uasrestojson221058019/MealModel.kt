package com.tegar.uasrestojson221058019

data class MealResponse(
    val meals: List<MealModel>
)

data class MealModel(
    val idMeal: String,
    val strMeal: String,
    val strCategory: String,
    val strMealThumb: String,
    val strInstructions: String
)