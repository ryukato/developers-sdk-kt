package com.github.ryukato.link.developers.sdk.model.response

import java.io.IOException

sealed class NetworkResponse<out T:Any, out U:Any> {
    /**
     * Success response with body
     * */
    data class Success<T:Any>(val body:T): NetworkResponse<T, Nothing>()
    /**
     * Failure response with body
     * non-2xx response, contains error body
     */
    data class ApiError<U:Any>(val body :U, val code:Int): NetworkResponse<Nothing, U>()
    /**
     * Network Error, such as no internet-connection
     * */
    data class NetworkError(val error:IOException): NetworkResponse<Nothing, Nothing>()
    /**
     * For example, json parsing error
     * */
    data class UnknownError(val error: Throwable?): NetworkResponse<Nothing, Nothing>()
}