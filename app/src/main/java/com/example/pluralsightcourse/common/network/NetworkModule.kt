package com.mmc.elagk.common.network

import android.util.Log
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import okhttp3.*
import okhttp3.internal.platform.Platform
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import java.util.concurrent.TimeUnit
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager


/**
 * Created by Aslm on 1/1/2020
 */

private val sLogLevel =
    HttpLoggingInterceptor.Level.BASIC


//private val loggingInterceptor = LoggingInterceptor.Builder()
//    .log(Platform.INFO)
//    .request("Request")
//    .response("Response")
//    .build()
//

private const val baseUrl = "https://ec2-52-47-205-231.eu-west-3.compute.amazonaws.com:8102"


private fun getLogInterceptor() = HttpLoggingInterceptor().apply { level = sLogLevel }

class ErrorLoggingInterceptor() : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request: Request = chain.request()
        val response = chain.proceed(request)
        when (response.code()) {
            400 -> {
                Log.i(javaClass.simpleName, "bad Request")
            }
            401 -> {
                //Show UnauthorizedError Message
                Log.i(javaClass.simpleName, "bad Request")
            }
            403 -> {
                Log.i(javaClass.simpleName, "bad Request")
                //Show Forbidden Message
            }
            404 -> {
                //Show NotFound Message
                Log.i(javaClass.simpleName, "bad Request")
            }
            // ... and so on
        }
        return response
    }
}

fun create8110NetworkClient() =
    retrofitClient(baseUrl, okHttpClient())

private fun okHttpClient() = OkHttpClient.Builder()

    .addInterceptor(getLogInterceptor()).apply { setTimeOutToOkHttpClient(this) }
    //.addInterceptor(loggingInterceptor)
    .addInterceptor(ErrorLoggingInterceptor())

var moshi = Moshi.Builder().build()
private fun retrofitClient(baseUrl: String, httpClient: OkHttpClient.Builder): Retrofit =
    Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(okHttpClient().build())
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()

private fun setTimeOutToOkHttpClient(okHttpClientBuilder: OkHttpClient.Builder) =
    okHttpClientBuilder.apply {
        readTimeout(60L, TimeUnit.SECONDS)
        connectTimeout(60L, TimeUnit.SECONDS)
        writeTimeout(60L, TimeUnit.SECONDS)
    }