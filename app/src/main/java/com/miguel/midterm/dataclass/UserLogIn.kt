package com.miguel.midterm.dataclass

// Data class for users log in
data class UserLogIn(
    val id: Int,
    val firstName: String,
    val lastName: String,
    val maidenName: String,
    val username: String,
    var password: String,
    var email: String,
    var phone: String,
    var image: String,
)
