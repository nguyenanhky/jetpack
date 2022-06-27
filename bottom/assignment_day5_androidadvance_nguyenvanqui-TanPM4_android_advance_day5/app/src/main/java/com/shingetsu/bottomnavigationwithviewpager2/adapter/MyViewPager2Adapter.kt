package com.shingetsu.bottomnavigationwithviewpager2.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.shingetsu.bottomnavigationwithviewpager2.fragment.DashboardFragment
import com.shingetsu.bottomnavigationwithviewpager2.fragment.HomeFragment
import com.shingetsu.bottomnavigationwithviewpager2.fragment.NotificationFragment

class MyViewPager2Adapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> HomeFragment()
            1 -> DashboardFragment()
            2 -> NotificationFragment()
            else -> HomeFragment()
        }
    }
}