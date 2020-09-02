package com.example.pluralsightcourse.features

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Window
import com.example.pluralsightcourse.R
import com.example.pluralsightcourse.common.base.BaseActivity
import kotlinx.android.synthetic.main.activity_submit.*
import kotlinx.android.synthetic.main.confirm_layout.*
import kotlinx.android.synthetic.main.confirm_layout.iv_close
import kotlinx.android.synthetic.main.success_failure_layout.*


class SubmitActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        btn_submit_.setOnClickListener {
           // showConfirmButton()
            showSuccessOrFailure(true)
        }

    }

    private fun showSuccessOrFailure(success: Boolean) {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(true)

        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT));
        dialog.setContentView(R.layout.success_failure_layout)
        if (success) {
            dialog.tv_success_failure_msg.text = resources.getString(R.string.submission_successfull_title)
            dialog.iv_success_failure.setBackgroundResource(R.drawable.ic_tick_icon)
        }else{
            dialog.tv_success_failure_msg.text = resources.getString(R.string.submission_fail_title)
            dialog.iv_success_failure.setBackgroundResource(R.drawable.ic_warning_icon)
        }
        dialog.show()
    }

    private fun showConfirmButton() {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(true)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT));
        dialog.setContentView(R.layout.confirm_layout)

        dialog.iv_close.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()
    }

    override fun provideLayout() = R.layout.activity_submit
}