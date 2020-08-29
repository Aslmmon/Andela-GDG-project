package com.example.pluralsightcourse.common.custom

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.pluralsightcourse.R

class CustomToolbar(context: Context, attrs: AttributeSet) : ConstraintLayout(context, attrs) {

    //var submit: MaterialButton

    init {
       // submit = findViewById(R.id.btn_submit)
        inflate(context, R.layout.custom_toolbar, this)
    }
}