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
            CarouselItem(R.drawable.bus_icon, "Alan"),
            CarouselItem(R.drawable.info_icon, "Marcos"),
            // Agrega más elementos aquí
        )
        val adapter = CarouselAdapter(carouselItems)
        viewPager.adapter = adapter
        return view
    }
}