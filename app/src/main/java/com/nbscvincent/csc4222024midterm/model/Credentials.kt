package com.nbscvincent.csc4222024midterm.model

import kotlinx.serialization.Serializable

@Serializable
data class Credentials(
    val id: Int,
    val username: String,
    val email: String,
    val firstName: String,
    val lastName: String,
    val gender: String,
    val image: String,
    val token: String,
)

data class LoginResonse(
    var flag: Int,
    val message: String
)