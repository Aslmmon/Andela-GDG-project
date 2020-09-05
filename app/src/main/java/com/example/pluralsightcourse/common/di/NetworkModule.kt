package com.example.pluralsightcourse.common.di

import com.example.pluralsightcourse.data.api.GoogleFormApi
import com.example.pluralsightcourse.data.api.MainLeadersApi
import com.mmc.elagk.common.network.*
import org.koin.dsl.module
import retrofit2.Retrofit

/**
 * Created by Aslm on 1/1/2020
 */

val retrofit8110: Retrofit = createNetworkClient()
val retrofit: Retrofit = createGoogleNetworkClient()

private val LEADERS_API: MainLeadersApi = retrofit8110.create(MainLeadersApi::class.java)
private val GOOGLE_API: GoogleFormApi = retrofit.create(GoogleFormApi::class.java)

val networkModule = module {
    single { LEADERS_API }
    single { GOOGLE_API }


}