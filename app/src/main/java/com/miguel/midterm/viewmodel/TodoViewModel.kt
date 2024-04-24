package com.miguel.midterm.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.miguel.midterm.dataclass.Todo
import com.miguel.midterm.repository.onlinerepository.TodoRepository
import timber.log.Timber

class TodosViewModel(private val todoRepository: TodoRepository) : ViewModel() {
    var todoList by mutableStateOf<List<Todo>>(emptyList())

    suspend fun getTodos() {
        try {
            val todos = todoRepository.getTodos()
            todoList = todos
            Timber.tag("").i("recipeList %s", todoList)
        } catch (e: Exception) {
            Timber.tag("").e(e, "Failed to fetch recipes: %s", e.message)
        }
    }
}