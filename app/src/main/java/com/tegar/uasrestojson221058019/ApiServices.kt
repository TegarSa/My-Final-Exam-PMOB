package com.tegar.uasrestojson221058019

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("search.php")
    suspend fun searchMeals(@Query("s") query: String): Response<MealResponse>
}
