package com.droidcon.data.datasources

import com.droidcon.data.api.User

internal interface UserDataSource {
    suspend fun getUsers(): List<User>
}