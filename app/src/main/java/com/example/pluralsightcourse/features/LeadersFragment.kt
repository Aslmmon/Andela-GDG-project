package com.example.pluralsightcourse.features

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import com.example.pluralsightcourse.R
import org.koin.android.viewmodel.ext.android.viewModel


class LeadersFragment : Fragment() {

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
            Toast.makeText(activity, parameter, Toast.LENGTH_SHORT).show()
        }

    }

    private fun observeForLeadersData() {
        leadersViewModel.leaders.observe(this, Observer {
            Log.i(javaClass.simpleName, it.toString())
        })
    }
}