package com.example.todoapp.api

class clima {
    suspend fun fetchWeather(city: String, apiKey: String) =
        retrofitConfig.api.getWeather(city, apiKey)
}