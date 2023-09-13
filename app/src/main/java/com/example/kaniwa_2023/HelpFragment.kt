package com.example.kaniwa_2023

import android.os.Bundle
import android.text.util.Linkify
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class HelpFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_help, container, false)

        // Se Obtiene una referencia al TextView
        val emailTextView: TextView = view.findViewById(R.id.correo)

        // Se Establece el correo electrónico como texto en el TextView
        val emailAddress = "alanarmando997@gmail.com"
        emailTextView.text = "Correo electrónico: $emailAddress"

        // Se convierte el texto en un enlace de correo electrónico
        Linkify.addLinks(emailTextView, Linkify.EMAIL_ADDRESSES)

        return view
    }
}