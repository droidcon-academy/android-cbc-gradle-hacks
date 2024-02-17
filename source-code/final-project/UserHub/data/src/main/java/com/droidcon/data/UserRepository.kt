package com.droidcon.data

import com.droidcon.data.api.User

interface UserRepository {
    suspend fun getUsers(): List<User>
}