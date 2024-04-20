package com.nbscvincent.csc4222024midterm.viewmodel

import androidx.lifecycle.ViewModel
import com.nbscvincent.csc4222024midterm.data.network.HttpRoutes
import com.nbscvincent.csc4222024midterm.data.network.KtorClient
import com.nbscvincent.csc4222024midterm.data.onlineRepository.OnlineToDoRepository
import com.nbscvincent.csc4222024midterm.data.onlineRepository.OnlineUserRepository
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

class ToDoViewModel(): ViewModel() {

    private val ktorClient: HttpClient = KtorClient()
    suspend fun getTodo() : String {
        var todo: String = ""
        try {
            val req = ktorClient.request(
                HttpRoutes.todos
            ){
                method = HttpMethod.Get
                url(HttpRoutes.todos)
                contentType(ContentType.Application.Json)
                accept(ContentType.Application.Json)
            }

            if (req.status.toString() == "200 OK") { // Check for successful response
                val response = req.body<ToDo>()
                todo = response.todo
            } else {
                // Log error response code
                Timber.e("Failed to fetch TODO data. Response code: ${req.status}")
            }

        } catch (e: Exception){
            // Log any exceptions
            Timber.e("Failed to fetch TODO data. Exception: $e")
        }
        return todo
    }
}
