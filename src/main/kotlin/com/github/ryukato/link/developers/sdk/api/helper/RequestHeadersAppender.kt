package com.github.ryukato.link.developers.sdk.api.helper

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.github.ryukato.link.developers.sdk.api.NONCE_HEADER
import com.github.ryukato.link.developers.sdk.api.SERVICE_API_KEY_HEADER
import com.github.ryukato.link.developers.sdk.api.SIGNATURE_HEADER
import com.github.ryukato.link.developers.sdk.api.TIMESTAMP_HEADER
import com.github.ryukato.link.developers.sdk.key.ApiKeySecret
import com.github.ryukato.link.developers.sdk.signature.DefaultSignatureGenerator
import com.github.ryukato.link.developers.sdk.signature.SignatureGenerator

import okhttp3.FormBody
import okhttp3.Headers
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.Request
import okhttp3.Response
import okio.Buffer
import java.time.Clock
import java.time.ZoneId

interface RequestHeadersAppender : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val headers = createNewHeaders(request)
        return chain.proceed(request.newBuilder().headers(headers).build())
    }

    fun createNewHeaders(request: Request): Headers
}

class DefaultRequestHeadersAppender(
    private val applicationClock: Clock,
    private val signatureGenerator: SignatureGenerator,
    private val nonceGenerator: NonceGenerator,
    private val serviceApiKey: String,
) : RequestHeadersAppender {
    override fun createNewHeaders(request: Request): Headers {
        val timestamp = applicationClock.instant().toEpochMilli()
        val nonce = nonceGenerator.newNonce()

        val queryParams: Map<String, List<String?>> = queryParameters(request)
        val body: Map<String, Any> = requestBody(request)
        val signature = signature(request, timestamp, nonce, queryParams, body)

        return newHeaders(request, signature, nonce, timestamp)
    }

    private fun signature(
        request: Request,
        timestamp: Long,
        nonce: String,
        queryParams: Map<String, List<String?>>,
        body: Map<String, Any>
    ): String {
        return signatureGenerator.generate(
            request.method,
            request.url.encodedPath,
            timestamp,
            nonce,
            queryParams,
            body,
        )
    }

    private fun requestBody(request: Request): Map<String, Any> {
        return if (request.method == "GET") {
            emptyMap()
        } else {
            if ((request.body?.contentLength() ?: 0) < 0) {
                emptyMap()
            } else {
                extractBodyFromRequest(request)
            }
        }
    }

    private fun queryParameters(request: Request): Map<String, List<String?>> {
        return request.url.queryParameterNames.associateWith {
            request.url.queryParameterValues(it)
        }
    }

    private fun newHeaders(request: Request, signature: String, nonce: String, timestamp: Long): Headers {
        return request.headers.newBuilder()
            .add(SERVICE_API_KEY_HEADER, serviceApiKey)
            .add(NONCE_HEADER, nonce)
            .add(SIGNATURE_HEADER, signature)
            .add(TIMESTAMP_HEADER, "$timestamp")
            .build()
    }

    private fun extractBodyFromRequest(request: Request): Map<String, Any> = when {
        request.body?.contentType() == JSON_MEDIA_TYPE -> {
            jsonBodyToMap(request)
        }
        request.body?.contentType() == FORM_MEDIA_TYPE -> {
            formBodyToMap(request)
        }
        else -> {
            throw IllegalArgumentException("Not supported media type")
        }
    }

    private fun jsonBodyToMap(request: Request): Map<String, Any> {
        return request.body?.let {
            val typeObject = object : TypeReference<Map<String, Any>>() {}
            val buffer = Buffer()
            it.writeTo(buffer)
            jacksonObjectMapper.readValue(buffer.inputStream(), typeObject)
        } ?: emptyMap()
    }

    private fun formBodyToMap(request: Request): Map<String, Any> {
        return (request.body)?.let {
            (request.body as FormBody).toMap()
        } ?: emptyMap()
    }

    companion object {
        private val jacksonObjectMapper = jacksonObjectMapper()
        private val JSON_MEDIA_TYPE = "application/json; charset=UTF-8".toMediaType()
        private val FORM_MEDIA_TYPE = "application/x-www-form-urlencoded".toMediaType()

        fun createDefaultInstance(apiKeySecret: ApiKeySecret): RequestHeadersAppender {
            return DefaultRequestHeadersAppender(
                Clock.system(ZoneId.systemDefault()),
                DefaultSignatureGenerator.createDefaultInstance(apiKeySecret.secret),
                DefaultStringNonceGenerator.createDefaultInstance(),
                apiKeySecret.key
            )
        }
    }
}

fun FormBody.toMap(): Map<String, String> {
    return this.let { formBody ->
        (0 until formBody.size).associate {
            formBody.name(it) to formBody.value(it)
        }
    }
}
