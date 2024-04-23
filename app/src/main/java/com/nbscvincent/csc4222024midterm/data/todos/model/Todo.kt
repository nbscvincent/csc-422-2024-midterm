package com.nbscvincent.csc4222024midterm.data.todos.model

import kotlinx.serialization.Serializable

@Serializable
data class Todo(
    val id: Int,
    val todo : String,
    val completed : Boolean,
    val userId : Int
)
