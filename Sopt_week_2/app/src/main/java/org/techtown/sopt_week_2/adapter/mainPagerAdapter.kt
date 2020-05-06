package org.techtown.sopt_week_2.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import org.techtown.sopt_week_2.Fragment1
import org.techtown.sopt_week_2.Fragment2
import org.techtown.sopt_week_2.Fragment3

class mainPagerAdapter(fm : FragmentManager): FragmentPagerAdapter(fm,
    BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getItem(position: Int): Fragment {
        return when(position){
            0 -> Fragment1()
            1 -> Fragment2()
            else -> Fragment3()
        }
    }

    override fun getCount(): Int = 3
}