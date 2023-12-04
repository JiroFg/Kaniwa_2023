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
            CarouselItem(R.drawable.alan, "Alan Armando Hernández Domínguez", "9242417055"),
            CarouselItem(R.drawable.marcos, "Marcos Yahir De la caña Pérez", "2791164035"),
            CarouselItem(R.drawable.erick, "Erick Adrián Hernández Aburto", "2281405346"),
            CarouselItem(R.drawable.edson, "Edson Jair Fuentes García","2283368916"),
            CarouselItem(R.drawable.perrones, "Alex Antonio Terrones Pacheco","2284001034"),
            // Agrega más elementos aquí
        )
        val adapter = CarouselAdapter(carouselItems)
        viewPager.adapter = adapter
        return view
    }
}