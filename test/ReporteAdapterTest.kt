package com.example.reporteproteccioncivil

import android.content.ContentResolver
import android.content.Context
import android.view.ViewGroup
import org.junit.Assert
import org.junit.Test
import org.junit.jupiter.api.Assertions.*
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import androidx.test.core.app.ApplicationProvider


@RunWith(RobolectricTestRunner::class)
@Config(sdk = [34])
class ReporteAdapterTest {

    @Test
    fun onBindViewHolder_ShouldSetViewsCorrectly() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val reporte1 = Reporte("uri1", "Incendio", "Descripción 1", "Ubicación 1")
        val reporte2 = Reporte("uri2", "Inundación", "Descripción 2", "Ubicación 2")
        val reportes = listOf(reporte1, reporte2)

        val adapter = ReporteAdapter(context, reportes)
        val viewHolder = adapter.createViewHolder(Mockito.mock(ViewGroup::class.java), 0)

        // Mock del context
        val mockContext = Mockito.mock(Context::class.java)
        Mockito.`when`(mockContext.contentResolver).thenReturn(Mockito.mock(ContentResolver::class.java))

        adapter.onBindViewHolder(viewHolder, 0)

        // Verificar que las vistas se hayan establecido correctamente
        Assert.assertEquals("Incendio", viewHolder.tipoIncidenteTextView.text)
        Assert.assertEquals("Descripción 1", viewHolder.descripcionTextView.text)
        Assert.assertEquals("Ubicación 1", viewHolder.ubicacionTextView.text)

        // Puedes agregar más aserciones según sea necesario para tu lógica específica
    }
}
