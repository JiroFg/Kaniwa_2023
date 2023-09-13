package com.example.kaniwa_2023.menu_desplegable

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import com.example.kaniwa_2023.R

class CostFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {

        // Inflar el diseño del fragmento
        val view = inflater.inflate(R.layout.fragment_cost, container, false)

        // Obtener una referencia al TextView en el diseño
        val textView = view.findViewById<TextView>(R.id.estudiantesPrecio)
        val textView2 = view.findViewById<TextView>(R.id.generalPrecio)
        val textView3 = view.findViewById<TextView>(R.id.inapamPrecio)

        // Cargar la fuente personalizada desde recursos
        val customFont = ResourcesCompat.getFont(requireContext(), R.font.dinnpro)

        // Aplicar la fuente personalizada al TextView
        customFont?.let {
            textView.typeface = it
            textView2.typeface = it
            textView3.typeface = it
        }
        return view

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cost, container, false)

    }
}