package com.example.kaniwa_2023.menu_desplegable

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.content.Intent
import android.net.Uri
import android.widget.Button
import com.example.kaniwa_2023.R

class HelpFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_help, container, false)

        // Se Obtiene una referencia al TextView
        //val emailTextView: TextView = view.findViewById(R.id.)
        val emailButton : Button = view.findViewById(R.id.emailButton)
        val recipientEmail = "alanarmando997@gmail.com"
        val subject = "Ayuda referente a Kaniwá"
        val message = "Detalla tu mensaje aquí..."


//        // Se Establece el correo electrónico como texto en el TextView
//        val emailAddress = "alanarmando997@gmail.com"
//        emailTextView.text = "Correo electrónico: $emailAddress"
//
//        // Se convierte el texto en un enlace de correo electrónico
//        Linkify.addLinks(emailTextView, Linkify.EMAIL_ADDRESSES)

        emailButton.setOnClickListener{
            val intent = Intent(Intent.ACTION_SEND).apply {
                data = Uri.parse("mailto:$recipientEmail") // Especifica que es una acción de correo electrónico
                putExtra(Intent.EXTRA_SUBJECT, subject) // Asunto del correo
                putExtra(Intent.EXTRA_TEXT, message) // Cuerpo del correo
            }

            if (intent.resolveActivity(requireActivity().packageManager) != null) {
                startActivity(intent)
            } else {
                // Maneja el caso en el que no haya aplicaciones de correo electrónico disponibles
                // o maneja el error de otra manera, como mostrar un mensaje de error al usuario.
            }
        }


        return view
    }
}