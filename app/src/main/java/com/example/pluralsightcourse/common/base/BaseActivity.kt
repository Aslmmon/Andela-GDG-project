package com.example.pluralsightcourse.common.base

import android.app.ProgressDialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity(){
    lateinit var loadingDialog: ProgressDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(provideLayout())
        loadingDialog = ProgressDialog(this)

    }

    abstract fun provideLayout(): Int

    fun showProgress() {
        loadingDialog.show()
    }

    fun dismissProgressDialog() {
        loadingDialog.dismiss()
    }

}