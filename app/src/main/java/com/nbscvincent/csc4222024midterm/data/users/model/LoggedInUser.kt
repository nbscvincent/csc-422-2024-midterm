package com.nbscvincent.csc4222024midterm.data.users.model

data class LoggedInUser(
    val id: Int,
    val firstName: String,
    val lastName: String,
    val username: String,
    var password: String,
    var email: String,
    var phone: String,
    var image: String,