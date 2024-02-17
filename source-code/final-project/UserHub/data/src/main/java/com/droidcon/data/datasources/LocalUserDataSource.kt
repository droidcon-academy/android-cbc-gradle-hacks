package com.droidcon.data.datasources

import com.droidcon.data.api.User
import javax.inject.Inject

internal class LocalUserDataSource @Inject constructor() : UserDataSource {

    override suspend fun getUsers(): List<User> {
        return emptyList()
    }
}