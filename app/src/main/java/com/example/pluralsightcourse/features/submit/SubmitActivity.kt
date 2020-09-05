package com.example.pluralsightcourse.features.submit

import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import com.example.pluralsightcourse.R
import com.example.pluralsightcourse.common.base.BaseActivity
import com.example.pluralsightcourse.common.showConfirmButton
import com.example.pluralsightcourse.common.showSuccessOrFailure
import com.example.pluralsightcourse.features.home.LeadersViewModel
import kotlinx.android.synthetic.main.activity_submit.*
import org.koin.android.viewmodel.ext.android.viewModel


class SubmitActivity : BaseActivity() {
    val leadersViewModel: LeadersViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        btn_submit_.setOnClickListener {
            val firstName = et_first_name.editText.text.toString()
            val lastName = et_last_name.editText.text.toString()
            val emailAddress = et_email_address.editText.text.toString()
            val link = et_project.editText.text.toString()
            showConfirmButton(onYesClicked = {
                leadersViewModel.submitProject(
                    name = firstName,
                    lastName = lastName,
                    email = emailAddress,
                    linkToProject = link
                )
            })
            //showSuccessOrFailure(success = true)
            // showSuccessOrFailure(true)

        }
        leadersViewModel.submitProject.observe(this, Observer {
            showSuccessOrFailure(success = true)
        })
        toolbar.backImg.setOnClickListener {
            finish()
        }
        leadersViewModel.errorResponse.observe(this, Observer {
            showSuccessOrFailure(success = false)
            //Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        })

    }


    override fun provideLayout() = R.layout.activity_submit
}