package com.droidcon.data

import com.droidcon.data.datasources.LocalUserDataSource
import com.droidcon.data.datasources.NetworkUserDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient

@InstallIn(SingletonComponent::class)
@Module
object DataModule {

    @Provides
    fun provideUserRepository(httpClient: HttpClient): UserRepository = UserRepositoryImpl(
        LocalUserDataSource(),
        NetworkUserDataSource(httpClient)
    )
}