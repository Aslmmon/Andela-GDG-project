package com.example.pluralsightcourse.features.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.pluralsightcourse.R
import com.example.pluralsightcourse.common.Constants.LEADERS_INTEGER
import com.example.pluralsightcourse.common.Constants.SKILLS_INTEGER
import com.example.pluralsightcourse.common.Navigation
import com.example.pluralsightcourse.common.base.BaseActivity
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initializeViewPagerWithTabMediator()
        custom_toolbar.submit.setOnClickListener {
            Navigation.goToSubmitActivity(this)
        }
    }

    private fun initializeViewPagerWithTabMediator() {
        pager.adapter = object : FragmentStateAdapter(this) {
            override fun createFragment(position: Int): Fragment {
                return when (position) {
                    0 -> LeadersFragment.newInstance(LEADERS_INTEGER)
                    1 -> LeadersFragment.newInstance(SKILLS_INTEGER)
                    else -> LeadersFragment()
                }
            }

            override fun getItemCount(): Int {
                return 2
            }
        }
        TabLayoutMediator(tab_layout, pager) { tab, position ->
            tab.text = when (position) {
                0 -> resources.getString(R.string.learning_leaders_title)
                1 -> resources.getString(R.string.skills_leaders_title)
                else -> ""
            }
        }.attach()
    }

    override fun provideLayout() = R.layout.activity_main
}