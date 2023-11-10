package com.example.reporteproteccioncivil

import android.content.Context
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity6 : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ReporteAdapter



    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main6)

        val atrasImageView = findViewById<ImageView>(R.id.atras)
        // volver atras en las pantallas
        atrasImageView.setOnClickListener {

            onBackPressed()
        }

        recyclerView = findViewById(R.id.recyclerView)
        adapter = ReporteAdapter(this,getReportesFromSharedPreferences())
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }

    public fun getReportesFromSharedPreferences(): List<Reporte> {
        val sharedPreferences = getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE)

        // Recupera los datos de SharedPreferences, suponiendo que has guardado datos
        // como tipo de incidente, descripción, ubicación y la URI de la imagen.
        val tipoIncidente = sharedPreferences.getString("tipoIncidente", "")
        val descripcion = sharedPreferences.getString("descripcion", "")
        val ubicacion = sharedPreferences.getString("ubicacion", "")
        val fotoPath = sharedPreferences.getString("fotoPath", "")

        // Crea una lista de Reporte con los datos recuperados
        val reportes = mutableListOf<Reporte>()

        // Añade un Reporte a la lista
        val reporte = Reporte(fotoPath, tipoIncidente, descripcion, ubicacion)
        reportes.add(reporte)

        // Aquí puedes agregar más Reporte si es necesario

        return reportes
    }
}
