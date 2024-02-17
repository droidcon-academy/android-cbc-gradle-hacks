package com.droidcon.network

import java.lang.Exception

sealed class Resource<out T> {
    data class Error(val e: Exception) : Resource<Nothing>()
    data class Success<R>(val result: R) : Resource<R>()
}