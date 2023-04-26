package com.example.agenda

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast

class Editar : AppCompatActivity() {

    lateinit var edNombre: EditText
    lateinit var edApellido: EditText
    lateinit var edEdad: EditText
    var id = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editar)
        //con este puedem recuperar los datos enviados
        val nombre = intent.getStringExtra("nombre")
        val apellido = intent.getStringExtra("apellido")
        val edad = intent.getStringExtra("edad")
        val idd = intent.getStringExtra("id")
        edNombre = findViewById(R.id.edNombre)
        edApellido = findViewById(R.id.edApellido)
        edEdad = findViewById(R.id.edEdad)


        id = Integer.parseInt(idd)
        edNombre.setText(nombre)
        edApellido.setText(apellido)
        edEdad.setText(edad)

    }
    fun guardar(v: View) {
        val nombre = edNombre.text.toString()
        val apellido = edApellido.text.toString()
        val edad = edEdad.text.toString()

        val persona = Persona(nombre,apellido,edad,id.toString())
        Provisional.listPersona[id]=persona
        Toast.makeText(this, "Se guardo", Toast.LENGTH_LONG).show()
        finish()
    }
}