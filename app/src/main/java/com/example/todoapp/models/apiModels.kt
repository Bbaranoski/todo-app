package com.example.todoapp.models

data class climaRespostaa(
    val nome: String,
    val main: String,
    val clima: List<climaDescricao>
)

data class climaDescricao(
    val descricao: String
)

data class mainData(
    val temp: Double,
    val umidade: Int
)
