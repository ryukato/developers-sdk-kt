package com.github.ryukato.link.developers.sdk.api.client

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.github.ryukato.link.developers.sdk.api.helper.DefaultRequestQueryParameterOrderer
import com.github.ryukato.link.developers.sdk.api.helper.RequestHeadersAppender
import com.github.ryukato.link.developers.sdk.api.helper.RequestQueryParameterOrderer

interface ApiClientFactory {
    fun build(
            baseUrl: String,
            enableLogging: Boolean,
            requestHeadersAppender: RequestHeadersAppender,
            requestQueryParameterOrderer: RequestQueryParameterOrderer,
            jacksonObjectMapper: ObjectMapper
    ): ApiClient
}
