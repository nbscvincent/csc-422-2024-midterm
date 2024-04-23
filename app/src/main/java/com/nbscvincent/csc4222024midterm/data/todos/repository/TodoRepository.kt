package com.nbscvincent.csc4222024midterm.data.todos.repository

import com.nbscvincent.csc4222024midterm.data.todos.model.Todo

interface TodoRepository {

    suspend fun getTodos(): List<Todo>


    suspend fun getTodoById(id: Int): Todo


    suspend fun addTodo(todo: Todo): Todo


    suspend fun updateTodo(todo: Todo): Todo


    suspend fun deleteTodo(id: Int): Boolean
}
