package com.example.kaniwa_2023

import android.content.Context
import android.content.Intent
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
        checkFirstTime()
        binding.viewPager.adapter = adapter
        confCircleIndicator()
    }

    private fun confCircleIndicator(){
        val indicator = binding.circleIndicator
        indicator.setViewPager(binding.viewPager)
    }

    private fun checkFirstTime(){
        val sharedPrefs = getSharedPreferences("sharedPrefs",Context.MODE_PRIVATE)
        val savedBool = sharedPrefs.getBoolean("FIRST_TIME", true)

        if(savedBool){
            val editPrefs = sharedPrefs.edit()
            editPrefs.apply{
                putBoolean("FIRST_TIME", false)
            }.apply()
        }else{
            startHomeActivity()
        }
    }

    private fun startHomeActivity(){
        val intent = Intent(this, HomeActivity::class.java).apply{}
        startActivity(intent)
        this.finish()
    }
}