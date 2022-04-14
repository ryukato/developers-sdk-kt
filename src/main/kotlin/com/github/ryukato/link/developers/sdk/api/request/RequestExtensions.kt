package com.github.ryukato.link.developers.sdk.api.request

fun String.isAlphanumeric(): Boolean = this.matches(TOKEN_NAME_REGEX)
fun String.notAllowedCharactersForTokenName(): String = this.filter { PATTERN_NOT_TOKEN_NAME.matches(it.toString()) }
fun String.notAllowedCharactersForTokenSymbol(): String = this.filter { SYMBOL_REGEX.matches(it.toString()) }


fun getInvalidServiceTokenNameMessage(name: String): String {
    return if (name.length !in NAME_LENGTH_RANGE) {
        "Invalid service token name: out of range($NAME_LENGTH_RANGE)"
    } else if (!name.isAlphanumeric()) {
        "Invalid service token name: not allowed characters(${name.notAllowedCharactersForTokenName()})"
    } else {
        ""
    }
}

fun getInvalidServiceTokenSymbolMessage(symbol: String): String {
    return if (symbol.length !in SYMBOL_LENGTH_RANGE) {
        "Invalid service token symbol: out of range($SYMBOL_LENGTH_RANGE)"
    } else if (!symbol.isAlphanumeric()) {
        "Invalid service token symbol: not allowed characters(${symbol.notAllowedCharactersForTokenSymbol()})"
    } else {
        ""
    }
}

fun getInvalidItemTokenNameMessage(name: String): String {
    return if (name.length !in NAME_LENGTH_RANGE) {
        "Invalid item token name: out of range($NAME_LENGTH_RANGE)"
    } else if (!name.isAlphanumeric()) {
        "Invalid item token name: not allowed characters(${name.notAllowedCharactersForTokenName()})"
    } else {
        ""
    }
}

