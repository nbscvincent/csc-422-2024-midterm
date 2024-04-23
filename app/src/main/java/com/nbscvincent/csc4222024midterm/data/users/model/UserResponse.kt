package com.nbscvincent.csc4222024midterm.data.users.model

import kotlinx.serialization.Serializable

@Serializable
data class UserResponse(
    val users: List<User>,
    val total: Int,
    val skip: Int,
    val limit: Int
)