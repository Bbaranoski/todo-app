package com.example.todoapp.api

import com.example.todoapp.models.climaResposta
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("weather")
    suspend fun getWeather(
        @Query("q") city: String,
        @Query("appid") apiKey: String
    ): Response<climaResposta>
}

val retrofit = Retrofit.Builder()
    .baseUrl("https://api.openweathermap.org/data/2.5/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

val climaApi = retrofit.create(ApiService::class.java)

val resposta = climaApi.getWeather("Brazil","c8b66c1912d946e96654fcaaf2cfb1ff")