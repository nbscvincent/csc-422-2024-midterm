package com.nbscvincent.csc4222024midterm.data.onlineRepository

import com.nbscvincent.csc4222024midterm.data.network.HttpRoutes
import com.nbscvincent.csc4222024midterm.data.network.KtorClient
import com.nbscvincent.csc4222024midterm.data.repository.ToDoRepository
import com.nbscvincent.csc4222024midterm.model.ToDo
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.accept
import io.ktor.client.request.request
import io.ktor.client.request.url
import io.ktor.http.ContentType
import io.ktor.http.HttpMethod
import io.ktor.http.contentType

class OnlineToDoRepository (private val ktorClient: HttpClient = KtorClient()): ToDoRepository {

     override suspend fun getToDo(): List<ToDo> {

        val response: List<ToDo> = ktorClient.request(HttpRoutes.todos) {
            method = HttpMethod.Get
            url(HttpRoutes.todos)
            contentType(ContentType.Application.Json)
            accept(ContentType.Application.Json)
        }.body()
        return response
    }
}