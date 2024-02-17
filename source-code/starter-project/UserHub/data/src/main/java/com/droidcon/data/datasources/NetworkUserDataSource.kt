package com.droidcon.data.datasources

import com.droidcon.data.api.User
import com.droidcon.data.api.UserApiResponse
import com.droidcon.network.Resource
import com.droidcon.network.get
import io.ktor.client.HttpClient
import javax.inject.Inject

internal class NetworkUserDataSource @Inject constructor(
    private val httpClient: HttpClient
) : UserDataSource {

    override suspend fun getUsers(): List<User> {
        return when (val result = httpClient.get<UserApiResponse>("users")) {
            is Resource.Error -> emptyList()
            is Resource.Success -> result.result.users
        }
    }
}