package com.example.pluralsightcourse.common.custom

import android.content.Context
import android.util.AttributeSet
import android.widget.EditText
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.pluralsightcourse.R

class CustomEditText(context: Context, attrs: AttributeSet) : ConstraintLayout(context, attrs) {
    var editText: EditText


    init {
        inflate(context, R.layout.custom_edit_text, this)
        editText = findViewById(R.id.edit_text)
        val attributes = context.obtainStyledAttributes(attrs, R.styleable.custom_edit_text)

        val hint: String? = attributes.getString(R.styleable.custom_edit_text_android_hint)
        hint?.let { editText.hint = it }





    }
}