package com.example.reporteproteccioncivil
import android.content.Context
import android.graphics.BitmapFactory
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.io.FileNotFoundException



class ReporteAdapter(private val context: Context, private val reportes: List<Reporte>) : RecyclerView.Adapter<ReporteAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val fotoImageView: ImageView = itemView.findViewById(R.id.fotoImageView)
        val tipoIncidenteTextView: TextView = itemView.findViewById(R.id.tipoIncidenteTextView)
        val descripcionTextView: TextView = itemView.findViewById(R.id.descripcionTextView)
        val ubicacionTextView: TextView = itemView.findViewById(R.id.ubicacionTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.tarjeta_reporte, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val reporte = reportes[position]

        val imageUriString = reporte.foto

        if (!imageUriString.isNullOrEmpty()) {
            try {
                val imageUri = Uri.parse(imageUriString)
                val inputStream = context.contentResolver.openInputStream(imageUri)
                val bitmap = BitmapFactory.decodeStream(inputStream)
                holder.fotoImageView.setImageBitmap(bitmap)
            } catch (e: FileNotFoundException) {
                e.printStackTrace()
                // Manejar el error si no se encuentra la imagen
            }
        } else {
            // Manejar el caso en que la URI de la imagen sea nula o vacía
            // Por ejemplo, puedes mostrar una imagen de marcador de posición.
        }
        holder.tipoIncidenteTextView.text = reporte.tipoIncidente
        holder.descripcionTextView.text = reporte.descripcion
        holder.ubicacionTextView.text = reporte.ubicacion
    }

    override fun getItemCount() = reportes.size
}
