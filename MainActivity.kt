package com.example.reporteproteccioncivil

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val registrarse = findViewById<Button>(R.id.registerButton)

        // genera un evento onclik y ejecuta el codigo dentro de las llaves
        registrarse.setOnClickListener {
            // con el intent generamos una actividad que en este caso es navegar a una nueva pantalla
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }

        val iniciarSesion = findViewById<Button>(R.id.loginButton)

        // genera un evento onclik y ejecuta el codigo dentro de las llaves
        iniciarSesion.setOnClickListener {
            // con el intent generamos una actividad que en este caso es navegar a una nueva pantalla
            val intent = Intent(this, MainActivity3::class.java)
            startActivity(intent)
        }


    }
}