package com.github.ryukato.link.developers.sdk.api.helper

import com.github.ryukato.link.developers.sdk.api.response.NetworkResponse
import okhttp3.Request
import okhttp3.ResponseBody
import okio.Timeout
import retrofit2.*
import java.io.IOException
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

internal class NetworkResponseCall<R : Any, E : Any>(
        private val delegate: Call<R>,
        private val errorBodyConverter: Converter<ResponseBody, E>
) : Call<NetworkResponse<R, E>> {
    override fun clone(): Call<NetworkResponse<R, E>> {
        return NetworkResponseCall(delegate.clone(), errorBodyConverter)
    }

    override fun execute(): Response<NetworkResponse<R, E>> {
        throw UnsupportedOperationException("NetworkResponseCall doesn't support execute")
    }

    override fun enqueue(callback: Callback<NetworkResponse<R, E>>) {
        return this.delegate.enqueue(object : Callback<R> {
            override fun onResponse(call: Call<R>, response: Response<R>) {
                val body = response.body()
                val code = response.code()
                val error = response.errorBody()

                if (response.isSuccessful) {
                    body?.let {
                        callback.onResponse(this@NetworkResponseCall, successBody(body))
                    } ?: callback.onResponse(this@NetworkResponseCall, unknownError())
                } else {
                    val errorBody = resolveErrorBody(error)
                    errorBody?.let {
                        callback.onResponse(this@NetworkResponseCall, apiError(errorBody, code))
                    } ?: callback.onResponse(this@NetworkResponseCall, unknownError())
                }
            }

            override fun onFailure(call: Call<R>, throwable: Throwable) {
                val response: Response<NetworkResponse<R, E>> = resoleFailure(throwable)
                callback.onResponse(this@NetworkResponseCall, response)
            }
        })
    }

    private fun resoleFailure(throwable: Throwable): Response<NetworkResponse<R, E>> {
        val networkResponse = when (throwable) {
            is IOException -> NetworkResponse.NetworkError(throwable)
            else -> NetworkResponse.UnknownError(throwable)
        }
        return Response.success(networkResponse)
    }

    private fun resolveErrorBody(error: ResponseBody?): E? {
        val errorBody = when {
            error == null || error.contentLength() == 0L -> null
            else -> try {
                errorBodyConverter.convert(error)
            } catch (e: Exception) {
                null
            }
        }
        return errorBody
    }

    private fun apiError(errorBody: E, code: Int): Response<NetworkResponse<R, E>> {
        return Response.success(NetworkResponse.ApiError(errorBody, code))
    }


    private fun successBody(body: R): Response<NetworkResponse<R, E>> {
        return Response.success(NetworkResponse.Success(body))
    }


    private fun unknownError(): Response<NetworkResponse<R, E>> {
        return Response.success(NetworkResponse.UnknownError(null))
    }

    override fun isExecuted(): Boolean = delegate.isExecuted

    override fun cancel() = delegate.cancel()

    override fun isCanceled(): Boolean = delegate.isCanceled

    override fun request(): Request = delegate.request()

    override fun timeout(): Timeout = delegate.timeout()
}


class NetworkResponseAdapter<R : Any, E : Any>(
        private val successType: Type,
        private val errorBodyConverter: Converter<ResponseBody, E>
) : CallAdapter<R, Call<NetworkResponse<R, E>>> {
    override fun responseType(): Type = successType

    override fun adapt(call: Call<R>): Call<NetworkResponse<R, E>> = NetworkResponseCall(call, errorBodyConverter)
}


class NetworkResponseAdapterFactory : CallAdapter.Factory() {
    override fun get(
            returnType: Type,
            annotations: Array<Annotation>,
            retrofit: Retrofit): CallAdapter<*, *>? {
        if (Call::class.java != getRawType(returnType)) {
            return null
        }

        check(returnType is ParameterizedType) {
            "return type must be parameterized as Call<NetworkResponse<<Foo>> or Call<NetworkResponse<out Foo>>"
        }

        val responseType = getParameterUpperBound(0, returnType)
        if (getRawType(responseType) != NetworkResponse::class.java) {
            return null
        }
        // the response type is Service and should be parameterized
        check(responseType is ParameterizedType) { "Response must be parameterized as NetworkResponse<Foo> or NetworkResponse<out Foo>" }

        val successBodyType = getParameterUpperBound(0, returnType)
        val errorBodyType = getParameterUpperBound(1, returnType)
        val errorBodyConverter = retrofit.nextResponseBodyConverter<Any>(
                null,
                errorBodyType,
                annotations
        )
        return NetworkResponseAdapter<Any, Any>(successBodyType, errorBodyConverter)
    }
}
