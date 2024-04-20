package com.nbscvincent.csc4222024midterm.model

import kotlinx.serialization.Serializable

@Serializable
data class ToDo(
    var id: Int,
    var todo: String,
    var completed: Boolean,
    var userID: Int
)

