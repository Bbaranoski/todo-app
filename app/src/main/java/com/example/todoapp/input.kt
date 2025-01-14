package com.example.todoapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.ComponentActivity
import com.example.todoapp.models.tarefa
import com.example.todoapp.models.todo
import com.example.todoapp.models.id

class Input : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input)

        val tituloInput = findViewById<EditText>(R.id.tituloInput)
        val descricaoInput = findViewById<EditText>(R.id.descricaoInput)

        val confirmar = findViewById<Button>(R.id.confirmar)
        confirmar.setOnClickListener {
            val tempTitulo = tituloInput.text.toString()

            val tempDescricao = descricaoInput.text.toString()

            tarefa.add(todo(id, tempTitulo, tempDescricao, false))

            id++

            println(tarefa)
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val cancelar = findViewById<Button>(R.id.cancelar)
        cancelar.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}