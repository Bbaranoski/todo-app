package com.example.todoapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.Guideline
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.api.clima
import com.example.todoapp.models.tarefa
import kotlinx.coroutines.launch
import kotlin.math.roundToInt

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

        // botão para descer o layout do clima
        val botaoToggle = findViewById<Button>(R.id.botaoCima)
        val guideToggle = findViewById<Guideline>(R.id.guideToggle)

        // elementos da aba temp
        val constraintTemp = findViewById<ConstraintLayout>(R.id.constraintTemp)
        var params = guideToggle.layoutParams as ConstraintLayout.LayoutParams
        var toggle = false
        constraintTemp.visibility = View.GONE

        botaoToggle.setOnClickListener{
            if(toggle == false){
                toggle = true
                params.guidePercent = 0.9f
                guideToggle.layoutParams = params
                constraintTemp.visibility = View.VISIBLE
                botaoToggle.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.ic_arrow_up, 0, 0, 0)
            }else{
                toggle = false
                params.guidePercent = 0.1f
                guideToggle.layoutParams = params
                constraintTemp.visibility = View.GONE
                botaoToggle.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.ic_arrow_down, 0, 0, 0)
            }
        }

        //consumindo a API
        lifecycleScope.launch {
            try {
                val resposta = clima().fetchWeather("London", "c8b66c1912d946e96654fcaaf2cfb1ff")
                println(resposta.body())
                if (resposta.isSuccessful){
                    val corpo = resposta.body()

                    val cidade = findViewById<TextView>(R.id.cidade)
                    val temp = findViewById<TextView>(R.id.temp)
                    val descricao = findViewById<TextView>(R.id.descricao)

                    cidade.text = corpo?.name
                    temp.text = "Temperatura: ${((corpo?.main?.temp ?: 0.0) - 273.15).roundToInt()} ºC"
                    descricao.text = corpo?.weather?.firstOrNull()?.description ?: "Descrição indisponível"

                }

            } catch (e: Exception) {
                println("Erro: ${e.message}")
            }
        }
    }
}

