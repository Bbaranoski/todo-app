package com.example.todoapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Switch
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.models.todo
import com.example.todoapp.models.edita
import com.example.todoapp.models.editaId

class Adapter(
    private val data: List<todo>
): RecyclerView.Adapter<Adapter.itemView>() {

    inner class itemView(view: View): RecyclerView.ViewHolder(view){
        val listaTitulo = view.findViewById<TextView>(R.id.listaTitulo)
        val listaFeito = view.findViewById<Switch>(R.id.listaFeito)
        val listaDescricao = view.findViewById<TextView>(R.id.listaDescricao)
        val listaDescContraint = view.findViewById<ConstraintLayout>(R.id.listaDescContraint)
        val listaBotaoEdita = view.findViewById<Button>(R.id.listaBotaoEdita)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): itemView {
        val inflated = LayoutInflater.from(parent.context).inflate(R.layout.lista, parent, false)
        return itemView(inflated)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: itemView, position: Int) {
        val Todo: todo = data[position]
        var temp = false

        holder.listaTitulo.text = Todo.titulo
        // aplicar descrição na lista e fazer um toogle que deixa ela invisivel/visivel
        if (Todo.descricao == "") {
            holder.listaDescricao.text = "Sem descrição"
        }else{
            holder.listaDescricao.text = Todo.descricao
        }
        holder.listaDescContraint.visibility = View.GONE
        holder.listaTitulo.setOnClickListener {
            if (temp == false){
                temp = true
                holder.listaDescContraint.visibility =  View.VISIBLE
            }else{
                temp = false
                holder.listaDescContraint.visibility =  View.GONE
            }
        }

        // botão que abre a tela para editar
        holder.listaBotaoEdita.setOnClickListener {
            edita = true
            editaId = Todo.id
            println(editaId)
            val intent = Intent(holder.itemView.context, Input::class.java)
            holder.itemView.context.startActivity(intent)
        }

        // configuração do switch para definir se vai estar marcado ou não
        holder.listaFeito.isChecked = Todo.concluido
        holder.listaFeito.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked){
                Todo.concluido = true
            }else{
                Todo.concluido = false
            }
        }
    }
}