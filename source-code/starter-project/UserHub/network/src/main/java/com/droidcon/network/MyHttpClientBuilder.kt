package com.droidcon.network

import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.header
import io.ktor.http.HttpHeaders
import io.ktor.http.URLProtocol
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

internal class MyHttpClientBuilder {
    private var protocol: URLProtocol = URLProtocol.HTTP
    private lateinit var host: String

    fun protocol(protocol: URLProtocol) = apply { this.protocol = protocol }

    fun host(host: String) = apply { this.host = host }

    fun build(): HttpClient {
        return HttpClient(Android) {
            expectSuccess = true

            engine {
                connectTimeout = 10_000
                socketTimeout = 10_000
            }

            defaultRequest {
                url {
                    protocol = this@MyHttpClientBuilder.protocol
                    host = this@MyHttpClientBuilder.host
                }
                header(HttpHeaders.ContentType, "application/json")
            }

            install(ContentNegotiation) {
                json(
                    Json {
                        prettyPrint = true
                        isLenient = true
                        ignoreUnknownKeys = true
                    },
                )
            }

            install(Logging) {
                logger = object : Logger {
                    override fun log(message: String) {
                        println(message)
                    }
                }
                level = LogLevel.ALL
            }
        }
    }
}