package com.example.pluralsightcourse.common.di


import com.example.pluralsightcourse.data.repo.LeadersRepo
import org.koin.dsl.module

/**
 * Created by Aslm on 1/1/2020
 */

val repositoriesModule = module {
    single{ LeadersRepo(get()) }
}