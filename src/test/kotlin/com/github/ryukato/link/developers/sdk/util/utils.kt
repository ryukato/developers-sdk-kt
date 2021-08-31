package com.github.ryukato.link.developers.sdk.util

import java.time.LocalDateTime
import java.time.ZoneOffset
import java.util.stream.Stream
import kotlin.random.Random
import kotlin.io.bufferedReader

val random: Random = Random(System.nanoTime())
const val PORT_RANGE_MIN = 1024
const val PORT_RANGE_MAX = 65535


fun loadJsonToString(classpathResource: String, claz: Class<*>): String {
    val content:String? = 
        claz.classLoader.getResourceAsStream(classpathResource)?.bufferedReader()?.let { it.readLines().joinToString("") }
    return content?: "{}"
}

fun LocalDateTime.toEpochMilli(): Long = this.toInstant(ZoneOffset.UTC).toEpochMilli()