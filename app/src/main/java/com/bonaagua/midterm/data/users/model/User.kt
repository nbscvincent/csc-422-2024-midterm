package com.bonaagua.midterm.data.users.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Entity("User")
@Serializable
data class User(
    @PrimaryKey
    @SerialName("id") val id: Int,
    @SerialName("firstName") val firstName: String,
    @SerialName("lastName") val lastName: String,
    @SerialName("username") val username: String,
    @SerialName("password") val password: String,
    @SerialName("email") val email: String,
    @SerialName("phone") val phone: String,
    @SerialName("image") val image: String,
)
