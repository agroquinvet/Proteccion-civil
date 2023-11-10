package com.example.reporteproteccioncivil

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import io.mockk.every
import io.mockk.mockk
import io.mockk.slot
import io.mockk.spyk
import io.mockk.verify
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [34])
class MainActivity5Test {

    private lateinit var activity: MainActivity5
    private lateinit var sharedPreferences: SharedPreferences
    private val context: Context = mockk()

    @Before
    fun setUp() {
        // Configura un contexto mock para la actividad
        every { context.getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE) } returns mockk(relaxed = true)

        // Crea una instancia de la actividad con el contexto mock
        activity = spyk(MainActivity5(), recordPrivateCalls = true)
        every { activity.applicationContext } returns context
    }

    @Test
    fun testOnActivityResultWithImage() {
        val imageUriString = "fake_image_uri"
        val data = mockk<Intent>()
        every { data.data } returns mockk()

        // Llama al método `onActivityResult` con los parámetros simulados
        activity.onActivityResult(2, Activity.RESULT_OK, data)

        // Verifica que se llamó a `getSharedPreferences` y `edit` para almacenar la imagen en SharedPreferences
        verify {
            context.getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE)
            sharedPreferences.edit()
        }
        // Verifica que se llamó a `putString` en el editor
        verify { sharedPreferences.edit().putString("fotoPath", imageUriString) }
    }
}
