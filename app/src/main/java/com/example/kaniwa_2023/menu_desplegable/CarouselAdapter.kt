package com.example.kaniwa_2023.menu_desplegable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kaniwa_2023.R

class CarouselAdapter(private val items: List<CarouselItem>) : RecyclerView.Adapter<CarouselAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //val imageView = itemView.findViewById<ImageView>(R.id.profile_image)
        val imageView = itemView.findViewById<ImageView>(R.id.imagenC)
        val textView = itemView.findViewById<TextView>(R.id.textoC)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_carousel, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.imageView.setImageResource(item.imageid)
        holder.textView.text = item.texto
    }

    override fun getItemCount(): Int {
        return items.size
    }
}