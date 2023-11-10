package com.example.reporteproteccioncivil

import org.junit.jupiter.api.Assertions.*


import android.widget.Button
import androidx.test.core.app.ActivityScenario
import io.mockk.mockk
import io.mockk.verify
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [34])
class MainActivity4Test {

    @Test
    fun testButtonClicks() {
        // Crea un mock para la actividad destino (MainActivity5 y MainActivity6)
        val mockMainActivity5 = mockk<MainActivity5>()
        val mockMainActivity6 = mockk<MainActivity6>()

        // Utiliza Robolectric para iniciar la actividad MainActivity4
        val scenario = ActivityScenario.launch(MainActivity4::class.java)

        // Realiza clic en el botón para hacer un reporte
        scenario.onActivity { activity ->
            activity.findViewById<Button>(R.id.hacerReporte).performClick()
        }

        // Verifica que se haya iniciado la actividad MainActivity5
        verify { mockMainActivity5.startActivity(any()) }

        // Realiza clic en el botón de reportes anteriores
        scenario.onActivity { activity ->
            activity.findViewById<Button>(R.id.reportesAnteriores).performClick()
        }

        // Verifica que se haya iniciado la actividad MainActivity6
        verify { mockMainActivity6.startActivity(any()) }

        // Finaliza la escena de la actividad
        scenario.close()
    }
}
