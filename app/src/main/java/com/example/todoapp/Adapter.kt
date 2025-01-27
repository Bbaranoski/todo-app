package com.example.todoapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Switch
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.models.todo

class Adapter(
    private val data: List<todo>
): RecyclerView.Adapter<Adapter.itemView>() {

    inner class itemView(view: View): RecyclerView.ViewHolder(view){
        val titulo = view.findViewById<TextView>(R.id.listaTitulo)
        val feito = view.findViewById<Switch>(R.id.listaFeito)
        val listaDescricao = view.findViewById<TextView>(R.id.listaDescricao)
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

        holder.titulo.text = Todo.titulo
        //holder.feito = Todo.concluido
        holder.listaDescricao.visibility = View.GONE
        holder.titulo.setOnClickListener {
            if (temp == false){
                temp = true
                holder.listaDescricao.visibility =  View.VISIBLE
            }else{
                temp = false
                holder.listaDescricao.visibility =  View.GONE
            }
        }
    }
}