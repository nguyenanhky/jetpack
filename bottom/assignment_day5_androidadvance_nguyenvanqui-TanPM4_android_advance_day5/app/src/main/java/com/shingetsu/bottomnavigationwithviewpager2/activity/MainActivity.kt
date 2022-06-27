package com.shingetsu.bottomnavigationwithviewpager2.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.shingetsu.bottomnavigationwithviewpager2.R
import com.shingetsu.bottomnavigationwithviewpager2.adapter.MyViewPager2Adapter
import com.shingetsu.bottomnavigationwithviewpager2.databinding.ActivityMainBinding
import com.shingetsu.bottomnavigationwithviewpager2.transformer.DepthPageTransformer

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter : MyViewPager2Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    private fun init(){
        adapter = MyViewPager2Adapter(this)
        binding.viewPager.adapter = adapter
        binding.viewPager.setPageTransformer(DepthPageTransformer())
        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                when (position){
                    0 -> binding.bottomNav.menu.findItem(R.id.menu_home).isChecked = true
                    1 -> binding.bottomNav.menu.findItem(R.id.menu_dashboard).isChecked = true
                    2 -> binding.bottomNav.menu.findItem(R.id.menu_notification).isChecked = true
                }
            }
        })

        binding.bottomNav.setOnItemSelectedListener {
            when (it.itemId){
                R.id.menu_home -> binding.viewPager.currentItem = 0
                R.id.menu_dashboard -> binding.viewPager.currentItem = 1
                R.id.menu_notification -> binding.viewPager.currentItem = 2

            }
            true
        }
    }
}