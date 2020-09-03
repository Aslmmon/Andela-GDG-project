package com.example.pluralsightcourse.features.splash

import android.os.Bundle
import com.example.pluralsightcourse.R
import com.example.pluralsightcourse.common.Navigation
import com.example.pluralsightcourse.common.base.BaseActivity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        GoingToMainActivity()
    }

    private fun GoingToMainActivity() {
        GlobalScope.launch {
            delay(3000)
            Navigation.goToMainActivity(this@SplashActivity)
        }
    }

    override fun provideLayout() = R.layout.activity_splash
}