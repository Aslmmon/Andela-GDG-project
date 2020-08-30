package com.example.pluralsightcourse.common

import android.app.Activity
import android.content.Context
import android.content.Intent
import com.example.pluralsightcourse.MainActivity
import com.example.pluralsightcourse.features.SubmitActivity


object Navigation {
    fun goToMainActivity(ctx: Context) {
        ctx.startActivity(Intent(ctx, MainActivity::class.java))
        (ctx as Activity).finish()
    }

    fun goToSubmitActivity(ctx: Context) {
        ctx.startActivity(Intent(ctx,SubmitActivity::class.java))
    }


}