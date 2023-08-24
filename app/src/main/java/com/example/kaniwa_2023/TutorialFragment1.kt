package com.example.kaniwa_2023

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kaniwa_2023.databinding.FragmentTutorial1Binding

class TutorialFragment1 : Fragment() {

    private var _binding: FragmentTutorial1Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTutorial1Binding.inflate(inflater, container, false)
        return binding.root
    }
}