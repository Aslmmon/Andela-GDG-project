package com.example.pluralsightcourse.common.base

import android.app.Activity
import android.app.ProgressDialog
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.koin.android.ext.android.inject

abstract class BaseFragment : Fragment() {
    lateinit var loadingDialog: ProgressDialog
    protected lateinit var activity: Activity
    private val sharedPreferences: SharedPreferences by inject()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //shimmer = shimmerFrame(activity)
        loadingDialog = ProgressDialog(activity)
        return inflater.inflate(provideLayout(), container, false)
    }


    abstract fun provideLayout(): Int

    fun showProgress() {
        loadingDialog.show()
    }

    fun dismissProgressDialog() {
        loadingDialog.dismiss()
    }

    override fun onAttach(activity: Activity) {
        super.onAttach(activity)
        this.activity = activity
    }

}