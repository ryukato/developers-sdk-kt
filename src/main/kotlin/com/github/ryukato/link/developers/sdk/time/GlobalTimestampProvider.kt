package com.github.ryukato.link.developers.sdk.time

import java.time.Clock

interface GlobalTimestampProvider {
    fun timestamp(): Long
}

class DefaultGlobalTimestampProvider() : GlobalTimestampProvider {
    // https://docs-blockchain.line.biz/api-guide#response-body
    private val globalClock = Clock.systemUTC()

    override fun timestamp(): Long = globalClock.millis()
}
