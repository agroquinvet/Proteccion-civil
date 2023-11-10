package com.example.reporteproteccioncivil

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        val atrasImageView = findViewById<ImageView>(R.id.atras)
        // volver atras en las pantallas
        atrasImageView.setOnClickListener {

            onBackPressed()
        }

        val userName = findViewById<EditText>(R.id.userName)
        val passwordEditText = findViewById<EditText>(R.id.pasword)
        val iniciarSesionButton = findViewById<Button>(R.id.iniciarSesion)

        iniciarSesionButton.setOnClickListener {
            // Obtener el nombre de usuario y contraseña ingresados por el usuario.
            val username = userName.text.toString()
            val password = passwordEditText.text.toString()

            // Validar las credenciales
            if (isValidCredentials(username, password)) {
                val intent = Intent(this, MainActivity4::class.java)
                startActivity(intent)
            } else {

                Toast.makeText(this, "Credenciales incorrectas", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun isValidCredentials(username: String, password: String): Boolean {
        val sharedPreferences = getSharedPreferences("Credenciales", Context.MODE_PRIVATE)
        val savedUsername = sharedPreferences.getString("username", null)
        val savedPassword = sharedPreferences.getString("password", null)

        // Comprobar si las credenciales coinciden con las almacenadas en SharedPreferences.
        return username == savedUsername && password == savedPassword
    }
}
