package com.example.pluralsightcourse.common.di

import com.mmc.elagk.common.network.*
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.create

/**
 * Created by Aslm on 1/1/2020
 */

val retrofit8110: Retrofit = create8110NetworkClient()

val networkModule = module {
//    single { LOGIN }


}