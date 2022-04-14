package com.github.ryukato.link.developers.sdk.signature

interface QueryParameterOrderer {
    fun sort(queryParams: Map<String, List<String?>>): Map<String, List<String?>>
    fun order(queryParams: Map<String, List<String?>>): Map<String, List<String?>> {
        return sort(queryParams)
    }
}
