package com.example.kaniwa_2023

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.kaniwa_2023.tutorial.TutorialFragment1
import com.example.kaniwa_2023.tutorial.TutorialFragment2
import com.example.kaniwa_2023.tutorial.TutorialFragment3

class ViewPagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {

    companion object{ private const val ARG_OBJECT = "object" }

    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> { TutorialFragment1() }
            1 -> { TutorialFragment2() }
            2 -> { TutorialFragment3() }
            else -> TutorialFragment1()
        }
        val fragment = TutorialFragment1()
        fragment.arguments = Bundle().apply {
            putInt(ARG_OBJECT, position + 1)
        }
        return fragment
    }
}