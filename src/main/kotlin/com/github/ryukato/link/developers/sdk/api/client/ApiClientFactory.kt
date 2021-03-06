package com.github.ryukato.link.developers.sdk.api.client

import com.fasterxml.jackson.databind.ObjectMapper
import com.github.ryukato.link.developers.sdk.api.helper.RequestHeadersAppender
import com.github.ryukato.link.developers.sdk.key.ApiKeySecret
import com.github.ryukato.link.developers.sdk.signature.RequestQueryParameterOrderer

interface ApiClientFactory {
    fun build(
        baseUrl: String,
        enableLogging: Boolean,
        requestHeadersAppender: RequestHeadersAppender,
        requestQueryParameterOrderer: RequestQueryParameterOrderer,
        jacksonObjectMapper: ObjectMapper
    ): ApiClient

    fun buildDefaultApiClient(
        baseUrl: String,
        enableLogging: Boolean,
        apiKeySecret: ApiKeySecret
    ) : ApiClient
}
