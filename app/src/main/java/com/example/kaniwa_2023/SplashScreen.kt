package com.example.kaniwa_2023

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.kaniwa_2023.databinding.ActivitySplashBinding

class SplashScreen : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Crear un retraso de 2 segundos (2000 milisegundos) antes de cambiar de actividad
        Handler().postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000) // Cambia este valor al tiempo en milisegundos que desees
    }
}



