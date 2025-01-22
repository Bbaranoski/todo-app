package com.example.todoapp.api

import com.example.todoapp.models.climaResposta
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("weather")
    suspend fun getWeather(
        @Query("q") city: String,
        @Query("appid") apiKey: String
    ): Response<climaResposta>
}


