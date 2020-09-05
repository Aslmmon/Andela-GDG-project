package com.example.pluralsightcourse.common

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.InsetDrawable
import android.view.ViewGroup
import com.example.pluralsightcourse.R
import kotlinx.android.synthetic.main.confirm_layout.*
import kotlinx.android.synthetic.main.success_failure_layout.*


fun Context.showSuccessOrFailure(success: Boolean) {
    val dialog = createDialog(R.layout.success_failure_layout)
    if (success) {
        dialog.tv_success_failure_msg?.text =
            this.resources?.getString(R.string.submission_successfull_title)
        dialog.iv_success_failure?.setBackgroundResource(R.drawable.ic_tick_icon)
    } else {
        dialog.tv_success_failure_msg?.text =
            this.resources?.getString(R.string.submission_fail_title)
        dialog.iv_success_failure?.setBackgroundResource(R.drawable.ic_warning_icon)
    }
    dialog.show()
}


fun Context.showConfirmButton(onYesClicked:() -> Unit) {
    val dialog = createDialog(R.layout.confirm_layout)
    dialog.iv_close.setOnClickListener {
        dialog.dismiss()
    }
    dialog.btn_yes.setOnClickListener {
        dialog.dismiss()
        onYesClicked()
    }
    dialog.show()
}

private fun Context.createDialog(layout: Int): Dialog {
    val dialog = Dialog(this)
    dialog.setCancelable(true)
    dialog.setContentView(layout)
    val back = ColorDrawable(Color.TRANSPARENT)
    val inset = InsetDrawable(back, 50)
    dialog.window?.setBackgroundDrawable(inset);
    dialog.window?.setLayout(
        ViewGroup.LayoutParams.MATCH_PARENT,
        ViewGroup.LayoutParams.WRAP_CONTENT
    );
    return dialog
}