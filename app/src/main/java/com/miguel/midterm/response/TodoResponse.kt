package com.miguel.midterm.response

import com.miguel.midterm.dataclass.Todo
import kotlinx.serialization.Serializable

@Serializable
data class TodoResponse(
    val todos: List<Todo>,
    val total: Int,
    val skip: Int,
    val limit: Int
)