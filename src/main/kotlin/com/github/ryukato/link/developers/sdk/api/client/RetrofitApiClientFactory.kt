package com.github.ryukato.link.developers.sdk.api.client

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.github.ryukato.link.developers.sdk.api.helper.DefaultRequestHeadersAppender
import com.github.ryukato.link.developers.sdk.api.helper.DefaultRequestQueryParameterOrderer
import com.github.ryukato.link.developers.sdk.api.helper.NetworkResponseAdapterFactory
import com.github.ryukato.link.developers.sdk.api.helper.RequestHeadersAppender
import com.github.ryukato.link.developers.sdk.api.helper.RequestQueryParameterOrderer
import com.github.ryukato.link.developers.sdk.key.ApiKeySecret
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

class RetrofitApiClientFactory : ApiClientFactory {
    override fun build(
        baseUrl: String,
        enableLogging: Boolean,
        requestHeadersAppender: RequestHeadersAppender,
        requestQueryParameterOrderer: RequestQueryParameterOrderer,
        jacksonObjectMapper: ObjectMapper,
    ): ApiClient {
        val okHttp3Client: OkHttpClient =
            httpClient(requestHeadersAppender, requestQueryParameterOrderer, enableLogging)
        val retrofit = retrofit(baseUrl, okHttp3Client, jacksonObjectMapper)
        return retrofit.create(ApiClient::class.java)
    }

    override fun buildDefaultApiClient(
        baseUrl: String,
        enableLogging: Boolean,
        apiKeySecret: ApiKeySecret
    ): ApiClient {
        val okHttp3Client: OkHttpClient =
            httpClient(
                DefaultRequestHeadersAppender.createDefaultInstance(apiKeySecret),
                DefaultRequestQueryParameterOrderer.createDefaultInstance(),
                enableLogging
            )
        val retrofit = retrofit(baseUrl, okHttp3Client, jacksonObjectMapper())
        return retrofit.create(ApiClient::class.java)
    }

    private fun retrofit(
        baseUrl: String,
        okHttp3Client: OkHttpClient,
        jacksonObjectMapper: ObjectMapper = jacksonObjectMapper(),
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addCallAdapterFactory(NetworkResponseAdapterFactory())
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(JacksonConverterFactory.create(jacksonObjectMapper))
            .client(okHttp3Client)
            .build()
    }

    private fun httpClient(
        requestHeadersAppender: RequestHeadersAppender,
        requestQueryParameterOrderer: RequestQueryParameterOrderer,
        enableLogging: Boolean,
    ): OkHttpClient {
        val logLevel =
            if (!enableLogging) HttpLoggingInterceptor.Level.NONE else HttpLoggingInterceptor.Level.BODY
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(logLevel)

        return OkHttpClient.Builder()
            .addInterceptor(requestHeadersAppender)
            .addInterceptor(requestQueryParameterOrderer)
            .addInterceptor(loggingInterceptor).build()
    }
}
