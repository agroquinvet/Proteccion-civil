package com.example.reporteproteccioncivil

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainActivity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        val atrasImageView = findViewById<ImageView>(R.id.atras)
        // volver atras en las pantallas
        atrasImageView.setOnClickListener {

            onBackPressed()
        }

        val hacerReporte = findViewById<Button>(R.id.hacerReporte)
        val repAnteriores = findViewById<Button>(R.id.reportesAnteriores)

        // genera un evento onclik y ejecuta el codigo dentro de las llaves
        hacerReporte.setOnClickListener {
            // con el intent generamos una actividad que en este caso es navegar a una nueva pantalla
            val intent = Intent(this, MainActivity5::class.java)
            startActivity(intent)
        }
        repAnteriores.setOnClickListener {
            // con el intent generamos una actividad que en este caso es navegar a una nueva pantalla
            val intent = Intent(this, MainActivity6::class.java)
            startActivity(intent)
        }


    }
}