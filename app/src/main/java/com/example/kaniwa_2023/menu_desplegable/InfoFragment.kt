package com.example.kaniwa_2023.menu_desplegable

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.kaniwa_2023.R

class InfoFragment : Fragment() {
    private lateinit var viewPager: ViewPager2
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_info, container, false)
        viewPager = view.findViewById(R.id.ViewP)
        val carouselItems = listOf(
            CarouselItem(R.drawable.alan, "Alan Armando Hernández Domínguez"),
            CarouselItem(R.drawable.marcos, "Marcos Yahir De la caña Pérez"),
            CarouselItem(R.drawable.erick, "Erick Adrián Hernández Aburto"),
            CarouselItem(R.drawable.edson, "Edson Jair Fuentes García"),
            CarouselItem(R.drawable.perrones, "Alex Antonio Terrones Pacheco"),
            // Agrega más elementos aquí
        )
        val adapter = CarouselAdapter(carouselItems)
        viewPager.adapter = adapter
        return view
    }
}