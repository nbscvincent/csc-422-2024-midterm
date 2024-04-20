package com.nbscvincent.csc4222024midterm.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.nbscvincent.csc4222024midterm.data.network.HttpRoutes
import com.nbscvincent.csc4222024midterm.data.network.KtorClient
import com.nbscvincent.csc4222024midterm.data.onlineRepository.OnlineToDoRepository
import com.nbscvincent.csc4222024midterm.data.onlineRepository.OnlineUserRepository
import com.nbscvincent.csc4222024midterm.data.repository.ToDoRepository
import com.nbscvincent.csc4222024midterm.model.ResponseQoutes
import com.nbscvincent.csc4222024midterm.model.ToDo
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.accept
import io.ktor.client.request.request
import io.ktor.client.request.url
import io.ktor.http.ContentType
import io.ktor.http.HttpMethod
import io.ktor.http.contentType
import io.ktor.http.isSuccess
import timber.log.Timber

class ToDoViewModel(private val toDoRepository: ToDoRepository): ViewModel() {
    var todoUiState by mutableStateOf(ToDoUiState())

    suspend fun getToDo() {
        val todo = toDoRepository.getToDo()
        todoUiState =
            ToDoUiState(todo = todo)
        Timber.i("postsUiState $todoUiState")
    }

    data class ToDoUiState(
        var todo: List<ToDo> = emptyList()
    )
}
