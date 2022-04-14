package com.github.ryukato.link.developers.sdk.api.request

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class UpdateServiceTokenRequestTest {

    @Test
    fun testEmptyName() {
       assertThrows<IllegalArgumentException> {
           UpdateServiceTokenRequest(
               ownerAddress = "tlink1ey2p39e4l78h49pm28z5ms62ycd06sgrprtps5",
               ownerSecret = "test",
               name = ""
           )
       }
    }

    @Test
    fun testNullName() {
        UpdateServiceTokenRequest(
            ownerAddress = "tlink1ey2p39e4l78h49pm28z5ms62ycd06sgrprtps5",
            ownerSecret = "test",
            name = null
        )
    }
}
