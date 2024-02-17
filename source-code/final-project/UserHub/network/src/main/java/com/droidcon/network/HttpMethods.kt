package com.droidcon.network

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

suspend inline fun <reified T> HttpClient.get(
    endpoint: String,
    queryParams: Map<String, Any> = emptyMap()
): Resource<T> {
    return try {
        val result = get(endpoint) {
            queryParams.forEach { (key, value) ->
                parameter(key, value)
            }
        }.body<T>()
        Resource.Success(result)
    } catch (e: Exception) {
        Resource.Error(e)
    }
}
