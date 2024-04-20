package com.nbscvincent.csc4222024midterm.model

data class UserProfile(
    val limit: Int,
    val skip: Int,
    val total: Int,
    val users: List<User>
)