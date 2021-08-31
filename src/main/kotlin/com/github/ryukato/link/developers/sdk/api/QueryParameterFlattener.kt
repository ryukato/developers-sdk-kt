package com.github.ryukato.link.developers.sdk.api

import java.util.TreeMap

interface QueryParameterFlattener {
    fun flatten(queryParams: Map<String, List<String?>>): String
}

class DefaultOrderedQueryParameterFlattener: QueryParameterFlattener, QueryParameterOrderer {
    override fun flatten(queryParams: Map<String, List<String?>>): String {
        val orderedMap = order(queryParams)
        return if (orderedMap.isEmpty()) {
            ""
        } else {
            orderedMap.filterValues { it.isNotEmpty() }.map { (k, v) ->
                "$k=${v.joinToString(",")}"
            }.joinToString("&")
        }
    }

    override fun sort(queryParams: Map<String, List<String?>>): Map<String, List<String?>> {
        return TreeMap<String, List<String?>>(queryParams)
    }
}