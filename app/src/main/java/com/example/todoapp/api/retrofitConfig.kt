package com.example.todoapp.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object retrofitConfig {
    val api: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.openweathermap.org/data/2.5/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}