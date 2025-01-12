package com.example.todoapp

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.todoapp.ui.theme.TodoAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val titulo = findViewById<TextView>(R.id.titulo)

        buh(titulo)
    }
}

data class Todo(
    var id: Int,
    var titulo: String,
    var descricao: String,
    var concluido: Boolean
)

val tarefa = mutableListOf<Todo>()

fun buh(temp: TextView) {
    tarefa.add(Todo(0,"Codar","codar o projeto",false))
    val ligma = tarefa[0]

    temp.text = ligma.descricao
}
