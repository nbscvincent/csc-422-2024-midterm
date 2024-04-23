package com.nbscvincent.csc4222024midterm.data.users.model

import kotlinx.serialization.Serializable

@Serializable
data class UserCredentials(
    val username: String,
    val password: String
)