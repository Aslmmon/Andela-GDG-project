package com.example.pluralsightcourse.features.leaders_fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import com.example.pluralsightcourse.R
import com.example.pluralsightcourse.features.leaders_fragment.adapter.LeadersRecyclerAdapter
import kotlinx.android.synthetic.main.fragment_leaders.*
import org.koin.android.viewmodel.ext.android.viewModel


class LeadersFragment : Fragment() {

    lateinit var leadersAdapter: LeadersRecyclerAdapter
    companion object {
        fun newInstance(typeOfData: String): Fragment {
            val args = Bundle()
            args.putString("data", typeOfData)
            val fragment = LeadersFragment()
            fragment.arguments = args
            return fragment
        }
    }

    val leadersViewModel: LeadersViewModel by viewModel()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_leaders, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        leadersAdapter = LeadersRecyclerAdapter()
        recycler.adapter = leadersAdapter

        if (arguments != null) {
            val parameter = arguments?.getString("data");
            when (parameter) {
                "1" -> {
                    leadersViewModel.getLeaders()
                    observeForLeadersData()
                }
                "2" -> {
                    leadersViewModel.getSkilledLeaders()
                    observeForLeadersData()
                }
            }
        }

    }

    private fun observeForLeadersData() {
        leadersViewModel.leaders.observe(this, Observer {
            leadersAdapter.submitList(it)
        })
    }
}