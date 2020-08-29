package com.example.pluralsightcourse.common.di

import android.content.Context
import android.content.SharedPreferences
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

/**
 * Created by Aslm on 1/1/2020
 */

val sharedPref = module {

    single{
        getSharedPrefrences(androidApplication())
    }

    single<SharedPreferences.Editor> {
        getSharedPrefrences(androidApplication()).edit()
    }


}

fun getSharedPrefrences(androidApplication: Context): SharedPreferences {
    return androidApplication.getSharedPreferences("elagk", Context.MODE_PRIVATE)
}