package com.github.ryukato.link.developers.sdk.api.request

const val PATTERN_TOKEN_NAME = "^[a-zA-Z0-9]{3,20}$"
const val PATTERN_URI_PATH = "[\\w\\.\\-\\~\\/]+"
const val PATTERN_BASE_URI = "^(https:\\/\\/)$PATTERN_URI_PATH(:[0-9]{1,5})?\\/$"
const val PATTERN_BASE_URI_OR_EMPTY = "^($PATTERN_BASE_URI)?$"
val PATTERN_NOT_TOKEN_NAME = "[^a-zA-Z0-9]$".toRegex()
val SYMBOL_REGEX = "^[A-Z][A-Z0-9]{1,4}$".toRegex()
val TOKEN_NAME_REGEX = PATTERN_TOKEN_NAME.toRegex()
val WALLET_ADDRESS_REGEX = "^t?link[a-zA-Z0-9]{39}$".toRegex()
val BASE_URI_OR_EMPTY_REGEX = PATTERN_BASE_URI_OR_EMPTY.toRegex()
val SERVICE_TOKEN_SYMBOL_REGEX = "^[A-Z][A-Z0-9]{1,4}$".toRegex()
val PATTERN_NUMERIC_VALUE_REGEX = "^[0-9]+$".toRegex()

const val CONTRACT_ID_REGEX = "^[a-f0-9]{8}"
val TOKEN_ID_REGEX = "^[a-f0-9]{16}".toRegex()
val TOKEN_TYPE_REGEX = "^[a-f0-9]{8}".toRegex()

const val MIN_LIMIT_1 = 1
const val MAX_LIMIT_50 = 50

const val DEFAULT_PAGE_1 = 1

val NAME_LENGTH_RANGE = 3..20
val SYMBOL_LENGTH_RANGE = 2..5
val META_LENGTH_RANGE = 0..1000
val MEMO_LENGTH_RANGE = 0..1000

