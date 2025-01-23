package com.tegar.uasrestojson221058019

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

class MainViewModel : ViewModel() {
    private val _meals = MutableLiveData<List<MealModel>>()
    val meals: LiveData<List<MealModel>> get() = _meals

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> get() = _error

    fun fetchMeals(query: String) {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.searchMeals(query)
                if (response.isSuccessful) {
                    _meals.postValue(response.body()?.meals)
                } else {
                    _error.postValue("Error: ${response.code()}")
                }
            } catch (e: HttpException) {
                _error.postValue("HttpException: ${e.message}")
            } catch (e: IOException) {
                _error.postValue("IOException: ${e.message}")
            }
        }
    }
}
