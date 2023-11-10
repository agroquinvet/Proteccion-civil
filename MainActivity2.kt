package com.example.reporteproteccioncivil

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity


class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val atrasImageView = findViewById<ImageView>(R.id.atras)
        // volver atras en las pantallas
        atrasImageView.setOnClickListener {

            onBackPressed()
        }

        fun saveCredentials(username: String, password: String) {
            val sharedPreferences = getSharedPreferences("Credenciales", Context.MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.putString("username", username)
            editor.putString("password", password)
            editor.apply()
        }

        val registrarseBoton = findViewById<Button>(R.id.registrarseBoton)
        val userName = findViewById<EditText>(R.id.userName)
        val passwordEditText = findViewById<EditText>(R.id.pasword)
        registrarseBoton.setOnClickListener {
            // Obtener el nombre de usuario y contraseña ingresados por el usuario.
            val username = userName.text.toString()
            val password = passwordEditText.text.toString()

            // Validar los datos ingresados (puedes agregar validaciones adicionales).

            // Guardar las credenciales en SharedPreferences.
            saveCredentials(username, password)

            // Redirigir al usuario a la pantalla de inicio de sesión.
            startActivity(Intent(this, MainActivity3::class.java))
        }

    }

    }
