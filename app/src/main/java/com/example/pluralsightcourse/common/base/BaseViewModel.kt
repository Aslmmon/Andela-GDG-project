package com.example.pluralsightcourse.common.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.zip
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

open class BaseViewModel() : ViewModel() {


    fun <T> getData(
        function: suspend CoroutineScope.() -> T, dataObserver: MutableLiveData<T>,
        loadingObserver: MutableLiveData<Boolean>? = null,
        errorObserver: MutableLiveData<String>? = null,
        finallyBlock: (suspend CoroutineScope.() -> Unit)? = null
    ) {
        this.viewModelScope.launch {
            try {
                dataObserver.value = function()
            } catch (e: Throwable) {
                val errorReturned = catchError(e)
            } finally {
                finallyBlock?.invoke(this)
            }
        }
    }

    fun <T, Y> getZippedData(
        firstFunction: suspend CoroutineScope.() -> T,
        secondFunction: suspend CoroutineScope.() -> Y,
        firstObserver: MutableLiveData<T>,
        secondObserver: MutableLiveData<Y>,
        finallyBlock: (suspend CoroutineScope.() -> Unit)? = null
    ) {
        this.viewModelScope.launch {
            try {
                val first = flowOf(firstFunction())
                val second = flowOf(secondFunction())
                first.zip(second) { firstData, secondData ->
                    firstObserver.value = firstData
                    secondObserver.value = secondData
                }.collect()
            } catch (e: Throwable) {
                val errorReturned = catchError(e)
                //     _ErrorMessage.value = errorReturned
            } finally {
            }
        }
    }

    private fun catchError(throwable: Throwable): String {
        throwable.printStackTrace()
        return when (throwable) {
            is IOException -> "NetworkError"
            is HttpException -> {
                val code = throwable.code()
                catchCodes(code, throwable)
            }
            else -> "${throwable.message}"
        }
    }

    private fun catchCodes(code: Int, throwable: HttpException): String {
        return when (code) {
            400 -> getError400Message(throwable)
            404 -> getErrorMessage(throwable) ?: "Not Found"
            403 -> "Forbidden"
            408 -> "Request Time Out"
            409 -> "Conflict"
            422 -> getErrorMessage(throwable) ?: "Error needed To be converted"
            410 -> "Gone"
            500 -> throwable.response()?.headers()?.get("application-error-message").toString()
            503 -> "GateWay timeout"
            else -> "Unknown Error"
        }
    }

    private fun getError400Message(throwable: HttpException): String {
        var errorMessage = "400 Unknown Error"
        val reponse = throwable.response()

        if (reponse != null) {
            val errorBody = reponse.errorBody()
            if (errorBody != null) {
                errorMessage = errorBody.string()
            } else {
                errorMessage = reponse.message().toString()
            }
        } else {
            errorMessage = throwable.message().toString()
        }

        return errorMessage

    }

    private fun getErrorMessage(throwable: HttpException): String? {
        val errorString = throwable.response()?.errorBody()?.string()
        var error = ""
        errorString?.let { err ->
            try {
                val gson = Gson()
            } catch (e: Exception) {
                error = errorString
            }

        }
        return error
    }



}