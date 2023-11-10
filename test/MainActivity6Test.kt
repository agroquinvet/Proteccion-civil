package com.example.reporteproteccioncivil

import org.junit.jupiter.api.Assertions.*
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import io.mockk.every
import io.mockk.mockk
import io.mockk.spyk
import io.mockk.verify
import org.junit.Before
import org.junit.Test
import org.assertj.core.api.Assertions.assertThat
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [34])
class MainActivity6Test {

    private lateinit var activity: MainActivity6

    @Before
    fun setUp() {
        // Configura un contexto mock para la actividad
        val context = mockk<Context>()
        every { context.getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE) } returns mockk(relaxed = true)
        activity = spyk(MainActivity6(), recordPrivateCalls = true)
        every { activity.applicationContext } returns context

        // Configura SharedPreferences para devolver datos simulados
        val sharedPreferences = mockk<SharedPreferences>(relaxed = true)
        every { context.getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE) } returns sharedPreferences

        // Simula los datos que se esperan de SharedPreferences
        every { sharedPreferences.getString("tipoIncidente", "") } returns "Incendio"
        every { sharedPreferences.getString("descripcion", "") } returns "Descripción del incidente"
        every { sharedPreferences.getString("ubicacion", "") } returns "Ubicación del incidente"
        every { sharedPreferences.getString("fotoPath", "") } returns "URI de la imagen"
    }

    @Test
    fun testRecyclerViewSetup() {
        // Llama al método `onCreate` de la actividad
        activity.onCreate(Bundle())

        // Verifica que se haya llamado a getReportesFromSharedPreferences
        verify { activity.getReportesFromSharedPreferences() }
    }

    @Test
    fun testGetReportesFromSharedPreferences() {
        // Crea una instancia aislada de MainActivity6 (sin ejecutar onCreate)
        val isolatedActivity = MainActivity6()

        // Llama al método getReportesFromSharedPreferences
        val reportes = isolatedActivity.getReportesFromSharedPreferences()

        // Verifica que los datos recuperados coincidan con lo esperado
        assertThat(reportes.size).isEqualTo(1)
        assertThat(reportes[0].tipoIncidente).isEqualTo("Incendio")
        assertThat(reportes[0].descripcion).isEqualTo("Descripción del incidente")
        assertThat(reportes[0].ubicacion).isEqualTo("Ubicación del incidente")
        assertThat(reportes[0].foto).isEqualTo("URI de la imagen")
    }
}

