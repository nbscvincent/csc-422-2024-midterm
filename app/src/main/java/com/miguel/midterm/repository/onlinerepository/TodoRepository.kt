package com.miguel.midterm.repository.onlinerepository

import com.miguel.midterm.dataclass.Todo

interface TodoRepository {

    suspend fun getTodos(): List<Todo>

    suspend fun getTodoById(id: Int): Todo

    suspend fun addTodo(todo: Todo): Todo

    suspend fun updateTodo(todo: Todo): Todo

    suspend fun deleteTodo(id: Int): Boolean
}
