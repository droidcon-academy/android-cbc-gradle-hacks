package com.droidcon.data.api


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserApiResponse(
    @SerialName("data")
    val users: List<User>,

    @SerialName("page")
    val page: Int,

    @SerialName("per_page")
    val perPage: Int,

    @SerialName("total")
    val total: Int,

    @SerialName("total_pages")
    val totalPages: Int
)