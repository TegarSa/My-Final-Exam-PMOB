package com.tegar.uasrestojson221058019

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class DataAdapter(private val meals: List<MealModel>) : RecyclerView.Adapter<DataAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textMealName: TextView = view.findViewById(R.id.textMealName)
        val textMealCategory: TextView = view.findViewById(R.id.textMealCategory)
        val imageMeal: ImageView = view.findViewById(R.id.imageMeal)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val meal = meals[position]
        holder.textMealName.text = meal.strMeal
        holder.textMealCategory.text = meal.strCategory
        Glide.with(holder.itemView.context).load(meal.strMealThumb).into(holder.imageMeal)

        // Set klik listener untuk membuka detail
        holder.itemView.setOnClickListener {
            val context = it.context
            val intent = Intent(context, DetailActivity::class.java).apply {
                putExtra("mealName", meal.strMeal)
                putExtra("mealCategory", meal.strCategory)
                putExtra("mealImage", meal.strMealThumb)
                putExtra("mealDescription", meal.strInstructions) // Kirim deskripsi makanan
            }
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = meals.size
}
