package com.example.kaniwa_2023

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kaniwa_2023.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val adapter by lazy { ViewPagerAdapter(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.viewPager.adapter = adapter
        val indicator = binding.circleIndicator
        indicator.setViewPager(binding.viewPager)
    }
}