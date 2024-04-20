package com.nbscvincent.csc4222024midterm.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Suppress("PLUGIN_IS_NOT_ENABLED")
@Serializable
@Entity(tableName = "user")
data class UserProfile(
    @PrimaryKey val username: String,
    val password: String,
    val expiresInMins: Int,
)

data class LoginResponse(
    var flag: Int,
    val message: String
)