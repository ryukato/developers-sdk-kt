package com.github.ryukato.link.developers.sdk.api.response

import java.io.IOException

sealed class ApiResonse<out T:Any> {
    /**
     * Success response with body
     * */
    data class Success<T:Any>(val body:T): ApiResonse<T>()
    /**
     * Failure response with body
     * non-2xx response, contains error body
     */
    data class ApiError<T:Any>(val body :T, val code:Int): ApiResonse<T>()
    /**
     * Network Error, such as no internet-connection
     * */
    data class NetworkError(val error:IOException): ApiResonse<Nothing>()
    /**
     * For example, json parsing error
     * */
    data class UnknownError(val error: Throwable?): ApiResonse<Nothing>()
}
