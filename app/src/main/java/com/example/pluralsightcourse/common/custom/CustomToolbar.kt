package com.example.pluralsightcourse.common.custom

import android.content.Context
import android.util.AttributeSet
import android.widget.Button
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.pluralsightcourse.R

class CustomToolbar(context: Context, attrs: AttributeSet) : ConstraintLayout(context, attrs) {

    var submit: Button

    init {
        inflate(context, R.layout.custom_toolbar, this)
        submit = findViewById(R.id.btn_submit)
        var toolBarTitle: TextView = findViewById(R.id.tv_toolbar_title)


    }
}