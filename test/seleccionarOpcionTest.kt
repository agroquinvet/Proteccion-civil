package com.example.reporteproteccioncivil

import org.junit.jupiter.api.Assertions.*

import android.content.Context
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import org.junit.Before
import org.junit.Test
import org.robolectric.Robolectric
import org.assertj.core.api.Assertions.assertThat
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [34])
class seleccionarOpcionTest{

    private lateinit var activity: MainActivity5

    @Before
    fun setUp() {
        activity = Robolectric.buildActivity(MainActivity5::class.java).create().get()
    }

    @Test
    fun testTipoIncidenteSeleccionado() {
        // Simula la selección de un tipo de incidente
        val tipoIncidenteSeleccionado = "Incendio"
        val spinner = activity.findViewById<Spinner>(R.id.TiposIncitdentes)
        val adapter = spinner.adapter
        val position = (adapter as ArrayAdapter<String>).getPosition(tipoIncidenteSeleccionado)
        spinner.setSelection(position)

        // Ejecuta el evento del botón de reporte
        val reportarButton = activity.findViewById<Button>(R.id.reportarButton)
        reportarButton.performClick()

        // Verifica que el tipo de incidente se almacene en SharedPreferences
        val sharedPreferences = activity.getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE)
        val tipoIncidenteAlmacenado = sharedPreferences.getString("tipoIncidente", null)

        // Verifica que el tipo de incidente almacenado sea igual al seleccionado
        assertThat(tipoIncidenteAlmacenado).isEqualTo(tipoIncidenteSeleccionado)
    }


}