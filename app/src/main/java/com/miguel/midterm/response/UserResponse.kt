package com.miguel.midterm.response

import com.miguel.midterm.dataclass.User
import kotlinx.serialization.Serializable

@Serializable
data class UserResponse(
    val users: List<User>,
    val total: Int,
    val skip: Int,
    val limit: Int
)