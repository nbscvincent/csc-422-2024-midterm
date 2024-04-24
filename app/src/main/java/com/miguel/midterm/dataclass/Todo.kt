package com.miguel.midterm.dataclass

import kotlinx.serialization.Serializable

@Serializable
data class Todo(
    val id: Int,
    val todo : String,
    val completed : Boolean,
    val userId : Int
)