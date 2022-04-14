package com.github.ryukato.link.developers.sdk.api.client

import com.github.ryukato.link.developers.sdk.key.ApiKeySecret
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.time.Instant

class ApiClientBasicTest {
    private lateinit var retrofitApiClientFactory: RetrofitApiClientFactory
    
    private val baseUrl = "https://test-api.blockchain.line.me/"
    private val invalidBaseUrl = "https://invali-url.com/"
    private val apiKeySecret =
        ApiKeySecret("02f94de7-cab9-47a0-b295-6211bf71125d", "02f94de7-cab9-47a0-b295-6211bf71125d")
    private val invalidApiKeySecret = ApiKeySecret("invalid-api-key", "invalid-api-secret")

    @BeforeEach
    fun setUp() {
        retrofitApiClientFactory = RetrofitApiClientFactory()
    }

    @Test
    fun test_success_time_api() {

        val apiClient = retrofitApiClientFactory.buildDefaultApiClient(
            baseUrl,
            false,
            apiKeySecret
        )
        val now = Instant.now().toEpochMilli()

        val timeResponse = runBlocking {
            apiClient.time()
        }

        assertNotNull((timeResponse))
        assertEquals(1000, timeResponse.statusCode)
        assertEquals("Success", timeResponse.statusMessage)
        assertTrue(timeResponse.responseTime > now)
        assertNull(timeResponse.responseData)
    }

    @Test
    fun test_error_time_api_invalid_service_api_key() {
        val apiClient = retrofitApiClientFactory.buildDefaultApiClient(
            baseUrl,
            false,
            invalidApiKeySecret
        )

        val now = Instant.now().toEpochMilli()

        val timeResponse = runBlocking {
            apiClient.time()
        }

        assertNotNull((timeResponse))
        assertEquals(4012, timeResponse.statusCode)
        assertEquals("Service-api-key not found", timeResponse.statusMessage)
        assertTrue(timeResponse.responseTime > now)
        assertNull(timeResponse.responseData)
    }

    @Test
    fun test_error_time_api_invalid_base_url() {
        val apiClient = retrofitApiClientFactory.buildDefaultApiClient(
            invalidBaseUrl,
            false,
            apiKeySecret
        )
        val timeResponse = runBlocking {
            apiClient.time()
        }

        assertNotNull((timeResponse))
        assertEquals(-1, timeResponse.statusCode)
        assertTrue(timeResponse.statusMessage.contains("UnknownHostException"))
    }
}
