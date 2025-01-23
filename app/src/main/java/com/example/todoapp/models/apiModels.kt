package com.example.todoapp.models

data class climaResposta(
    val nome: String,
    val main: Any,
    val clima: List<climaDescricao>
)

data class climaDescricao(
    val descricao: String
)

data class mainData(
    val temp: Double,
    val umidade: Int
)
