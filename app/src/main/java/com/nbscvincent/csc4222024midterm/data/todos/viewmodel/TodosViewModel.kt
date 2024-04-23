package com.nbscvincent.csc4222024midterm.data.todos.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.nbscvincent.csc4222024midterm.data.todos.model.Todo
import com.nbscvincent.csc4222024midterm.data.todos.repository.TodoRepository

class TodosViewModel(private val todoRepository: TodoRepository) : ViewModel() {
    var todoList by mutableStateOf<List<Todo>>(emptyList())


    suspend fun getTodos() {
        try {
            val todos = todoRepository.getTodos()
            todoList = todos
            Log.i("", "recipeList $todoList")
        } catch (e: Exception) {
            Log.e("", "Failed to fetch recipes: ${e.message}", e)
        }
    }
}

