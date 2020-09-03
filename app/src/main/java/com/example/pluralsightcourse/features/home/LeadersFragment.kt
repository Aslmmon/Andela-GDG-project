package com.example.pluralsightcourse.features.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.example.pluralsightcourse.R
import com.example.pluralsightcourse.common.Constants.LEADERS_INTEGER
import com.example.pluralsightcourse.common.Constants.SKILLS_INTEGER
import com.example.pluralsightcourse.common.Constants.TYPE_OF_DATA_NEEDED
import com.example.pluralsightcourse.features.home.adapter.LeadersRecyclerAdapter
import kotlinx.android.synthetic.main.fragment_leaders.*
import org.koin.android.viewmodel.ext.android.viewModel


class LeadersFragment : Fragment() {

    lateinit var leadersAdapter: LeadersRecyclerAdapter
    val leadersViewModel: LeadersViewModel by viewModel()


    companion object {
        fun newInstance(typeOfData: String): Fragment {
            val args = Bundle()
            args.putString(TYPE_OF_DATA_NEEDED, typeOfData)
            val fragment = LeadersFragment()
            fragment.arguments = args
            return fragment
        }
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_leaders, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeRecyclerAdaper()
        checkWhichDataToBeDisplayed()
        observeForLeadersData()
    }

    private fun checkWhichDataToBeDisplayed() {
        if (arguments != null) {
            val parameter = arguments?.getString(TYPE_OF_DATA_NEEDED);
            when (parameter) {
                LEADERS_INTEGER -> leadersViewModel.getLeaders()
                SKILLS_INTEGER -> leadersViewModel.getSkilledLeaders()
            }
        }
    }

    private fun initializeRecyclerAdaper() {
        leadersAdapter = LeadersRecyclerAdapter()
        recycler.adapter = leadersAdapter
    }

    private fun observeForLeadersData() {
        leadersViewModel.leaders.observe(this, Observer {
            leadersAdapter.submitList(it)
        })
    }
}