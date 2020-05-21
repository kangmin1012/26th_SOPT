package org.techtown.sopt_week_3.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.activity_home.*
import org.techtown.sopt_week_2.adapter.mainPagerAdapter
import org.techtown.sopt_week_3.R

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        main_viewPager.adapter = mainPagerAdapter(supportFragmentManager)
        main_viewPager.offscreenPageLimit = 2

        main_viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                //네비게이션 메뉴 체크 될 경우
                main_bottomNavi.menu.getItem(position).isChecked = true
            }
        })

        main_bottomNavi.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.menu_home -> main_viewPager.currentItem = 0
                R.id.menu_recycler -> main_viewPager.currentItem = 1
                R.id.menu_find -> main_viewPager.currentItem = 2
            }
            true
        }
    }
}
