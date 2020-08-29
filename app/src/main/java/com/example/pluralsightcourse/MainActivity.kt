package com.example.pluralsightcourse

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.pluralsightcourse.common.base.BaseActivity
import com.example.pluralsightcourse.features.LeadersFragment
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        pager.adapter = object : FragmentStateAdapter(this) {
            override fun createFragment(position: Int): Fragment {
                return when (position) {
                    0 -> LeadersFragment()
                    1 ->  LeadersFragment()
                    else -> LeadersFragment()
                }
            }

            override fun getItemCount(): Int {
                return 2
            }
        }
        pager.isUserInputEnabled = false
        TabLayoutMediator(tab_layout, pager) { tab, position ->
            tab.text = when (position) {
                0 -> "Learning Leaders"
                1 -> "Skill IQ Leaders"
                else -> "New"
            }
        }.attach()
    }

    override fun provideLayout() = R.layout.activity_main
}