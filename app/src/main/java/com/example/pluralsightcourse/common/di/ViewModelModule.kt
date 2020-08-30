package com.example.pluralsightcourse.common.di


import com.example.pluralsightcourse.features.LeadersViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by Aslm on 1/1/2020
 */

val viewModelModule = module {
    viewModel { LeadersViewModel(get()) }
}