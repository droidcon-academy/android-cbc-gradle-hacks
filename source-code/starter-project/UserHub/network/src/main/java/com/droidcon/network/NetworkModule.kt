package com.droidcon.network

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import io.ktor.http.URLProtocol

@InstallIn(SingletonComponent::class)
@Module
object NetworkModule {
    @Provides
    fun provideHttpClient(): HttpClient =
        MyHttpClientBuilder().host("reqres.in/api").protocol(URLProtocol.HTTPS).build()
}