package com.example.todoapp.models

data class climaResposta(
    val name: String,
    val main: mainData,
    val weather: List<climaDescricao>
)

data class climaDescricao(
    val description: String
)

data class mainData(
    val temp: Double,
    val humidity: Int
)
