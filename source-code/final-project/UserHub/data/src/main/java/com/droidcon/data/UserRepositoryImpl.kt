package com.droidcon.data

import com.droidcon.data.api.User
import com.droidcon.data.datasources.LocalUserDataSource
import com.droidcon.data.datasources.NetworkUserDataSource
import javax.inject.Inject

internal class UserRepositoryImpl(
    private val local: LocalUserDataSource,
    private val network: NetworkUserDataSource
) : UserRepository {

    override suspend fun getUsers(): List<User> {
        return local.getUsers().ifEmpty {
            network.getUsers()
            //@Todo save network users to local database
        }
    }
}