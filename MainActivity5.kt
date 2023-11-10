package com.example.reporteproteccioncivil

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Spinner
import android.widget.Toast

class MainActivity5 : AppCompatActivity() {
    private val REQUEST_MAPS = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main5)

        val atrasImageView = findViewById<ImageView>(R.id.atras)
        // volver atras en las pantallas
        atrasImageView.setOnClickListener {

            onBackPressed()
        }

        //manu de opciones
        val spinner: Spinner = findViewById(R.id.TiposIncitdentes)
        val opciones = arrayOf("Selecionar","Incendio", "Inundaciones", "Ayuda a la comunidad", "Accidentes", "Otros")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, opciones)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        // camra
        val camaraIcon = findViewById<ImageView>(R.id.camaraIcon)
        camaraIcon.setOnClickListener {
            val pickImageIntent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            if (pickImageIntent.resolveActivity(packageManager) != null) {
                startActivityForResult(pickImageIntent, 2)
            }
        }





        //descripcion
        val reportarButton = findViewById<Button>(R.id.reportarButton)
        val descripcionEditText = findViewById<EditText>(R.id.descriptionEditText)
        val ubicaEditText = findViewById<EditText>(R.id.ubicacion)

        reportarButton.setOnClickListener {
            // Obtener la descripción ingresada por el usuario
            val descripcion = descripcionEditText.text.toString()
            val ubicacion = ubicaEditText.text.toString()

            // Guardar la descripción en SharedPreferences
            val sharedPreferences = getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.putString("descripcion", descripcion)
            editor.apply()

            val sharedPreferencesubi = getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE)
            val editorubi = sharedPreferencesubi.edit()
            editorubi.putString("ubicacion", ubicacion)
            editorubi.apply()

            val tipoIncidente = spinner.selectedItem.toString()

            // Guardar el tipo de incidente en SharedPreferences
            val sharedPreferencesin = getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE)
            val editorin = sharedPreferencesin.edit()
            editorin.putString("tipoIncidente", tipoIncidente)
            editorin.apply()

            Toast.makeText(this, "El reporte de incidente ha sido almacenado correctamente", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, MainActivity6::class.java)
            startActivity(intent)
        }



    }
    public override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 2 && resultCode == RESULT_OK && data != null) {
            val imageUri = data.data // URI de la imagen seleccionada

            // Convierte la URI a una cadena de texto
            val imageUriString = imageUri.toString()

            // Guarda la URI en Shared Preferences
            val sharedPreferences = getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.putString("fotoPath", imageUriString)
            editor.apply()
        }

    }

}