package com.example.pluralsightcourse.common.custom

import android.content.Context
import android.util.AttributeSet
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.pluralsightcourse.R

class CustomToolbarSubmitActivity(context: Context, attrs: AttributeSet) : ConstraintLayout(context, attrs) {

    var backImg :ImageView

    init {
        inflate(context, R.layout.custom_toolbar_submit, this)
        backImg = findViewById(R.id.iv_toolbar_back)


    }
}