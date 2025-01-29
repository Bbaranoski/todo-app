package com.example.todoapp.models

// array de objetos
val tarefa = mutableListOf<todo>()

var id: Int = 0
var edita: Boolean = false
var editaId: Int = 0

// object constructor das tarefas criadas
data class todo(
    var id: Int,
    var titulo: String,
    var descricao: String,
    var concluido: Boolean
)
