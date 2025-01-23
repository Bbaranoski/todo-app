package com.example.todoapp

import android.content.Intent
import android.os.Bundle
import android.provider.Telephony.Mms.Intents
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.LinearLayout
import androidx.activity.ComponentActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.Guideline
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.api.clima
import com.example.todoapp.models.tarefa
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // botão que troca para a tela input
        val botao = findViewById<Button>(R.id.add)
        botao.setOnClickListener{
            val intent = Intent(this, Input::class.java)
            startActivity(intent)
        }

        // conectando o recycler com o layout e a lista
        val recycler = findViewById<RecyclerView>(R.id.recyclerView)
        recycler.adapter = Adapter(tarefa)
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.layoutManager = LinearLayoutManager(this)

        val botaoToggle = findViewById<ImageButton>(R.id.botaoCima)
        val guideToggle = findViewById<Guideline>(R.id.guideToggle)
        var params = guideToggle.layoutParams as ConstraintLayout.LayoutParams
        var toggle = false

        botaoToggle.setOnClickListener{
            if(toggle == false){
                toggle = true
                params.guidePercent = 0.9f
                guideToggle.layoutParams = params
            }else{
                toggle = false
                params.guidePercent = 0.1f
                guideToggle.layoutParams = params
            }
        }

        lifecycleScope.launch {
            try {
                val resposta = clima().fetchWeather("Brazil", "c8b66c1912d946e96654fcaaf2cfb1ff")
                println(resposta)
            } catch (e: Exception) {
                println("Erro: ${e.message}")
            }
        }
    }
}

