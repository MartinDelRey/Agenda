package com.example.agenda

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adaptador (private var contexto: Context) :
    RecyclerView.Adapter<Adaptador.ViewHolderPersona>(){

    class ViewHolderPersona(item: View):
        RecyclerView.ViewHolder(item){
        var txtNombre:TextView = item.findViewById(
            R.id.txtNombre)
        var txtApellido:TextView = item.findViewById(
            R.id.txtApellido)
        var txtEdad:TextView = item.findViewById(
            R.id.txtEdad)
    }

    //Llena los datos en cada repeticion
    override fun onBindViewHolder(holder: ViewHolderPersona, position: Int) {
        val persona = Provisional.listPersona[position]
        val activity = contexto as MainActivity
        holder.txtNombre.text = persona.nombre
        holder.txtApellido.text = persona.apellido
        holder.txtEdad.text = persona.edad
        holder.itemView.setOnClickListener{
            activity.onClickpersona(persona)
        }
    }
    // sirve para especificar la vistya que quieren recargar
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderPersona {
        val layoutItem = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_view, parent, false)
        return ViewHolderPersona(layoutItem)
    }
    //sirve para decir cuantas se va a repetir
    override fun getItemCount(): Int
            = Provisional.listPersona.size
}