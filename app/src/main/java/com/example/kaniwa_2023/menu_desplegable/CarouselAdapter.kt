package com.example.kaniwa_2023.menu_desplegable
import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.kaniwa_2023.R

class CarouselAdapter(private val items: List<CarouselItem>) : RecyclerView.Adapter<CarouselAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //val imageView = itemView.findViewById<ImageView>(R.id.profile_image)
        val imageView = itemView.findViewById<ImageView>(R.id.imagenC)
        val textView = itemView.findViewById<TextView>(R.id.textoC)
        val chatNumero = itemView.findViewById<Button>(R.id.chat)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_carousel, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.imageView.setImageResource(item.imageid)
        holder.textView.text = item.texto
        holder.chatNumero.setOnClickListener {
            // Abre WhatsApp con el número de teléfono directamente
            openWhatsAppChat(holder.itemView.context, item.phoneNumber)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
    fun openWhatsAppChat(context: Context, phoneNumber: String) {
        try {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://wa.me/$phoneNumber")
            context.startActivity(intent)
        } catch (e: ActivityNotFoundException) {
            // Maneja la excepción si WhatsApp no está instalado en el dispositivo
            Toast.makeText(context, "WhatsApp no está instalado", Toast.LENGTH_SHORT).show()
        }
    }
}