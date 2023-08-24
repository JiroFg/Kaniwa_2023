package com.example.kaniwa_2023

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.kaniwa_2023.databinding.FragmentTutorial1Binding
import com.example.kaniwa_2023.databinding.FragmentTutorial3Binding

class TutorialFragment3 : Fragment() {

    private var _binding: FragmentTutorial3Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTutorial3Binding.inflate(inflater, container, false)

        binding.finishBtn.setOnClickListener { startHomeActivity() }

        return binding.root
    }

    private fun startHomeActivity(){
        val intent = Intent(activity, HomeActivity::class.java).apply{}
        startActivity(intent)
        activity?.finish()
    }
}