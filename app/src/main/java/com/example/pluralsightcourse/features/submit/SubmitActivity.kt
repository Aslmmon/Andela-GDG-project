package com.example.pluralsightcourse.features.submit

import android.os.Bundle
import com.example.pluralsightcourse.R
import com.example.pluralsightcourse.common.base.BaseActivity
import com.example.pluralsightcourse.common.showConfirmButton
import com.example.pluralsightcourse.common.showSuccessOrFailure
import kotlinx.android.synthetic.main.activity_submit.*


class SubmitActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        btn_submit_.setOnClickListener {
        //    showConfirmButton()
            showSuccessOrFailure(success = true)
            // showSuccessOrFailure(true)
        }
        toolbar.backImg.setOnClickListener {
            finish()
        }

    }


    override fun provideLayout() = R.layout.activity_submit
}