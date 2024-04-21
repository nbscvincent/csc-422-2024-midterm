package com.bonaagua.midterm.data.todos.repository


import com.bonaagua.midterm.data.todos.model.Todo
import com.bonaagua.midterm.data.todos.model.TodoResponse
import com.bonaagua.midterm.network.HttpRoutes
import com.bonaagua.midterm.network.KtorClient
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.accept
import io.ktor.client.request.request
import io.ktor.client.request.url
import io.ktor.http.ContentType
import io.ktor.http.HttpMethod
import io.ktor.http.contentType
import io.ktor.util.InternalAPI

@OptIn(InternalAPI::class)
class OnlineTodoRepository(private val ktorClient: HttpClient = KtorClient()) : TodoRepository {

    override suspend fun getTodos(): List<Todo> {
        val response: TodoResponse = ktorClient.request(HttpRoutes.TODOS) {
            method = HttpMethod.Get
            url(HttpRoutes.TODOS)
            contentType(ContentType.Application.Json)
            accept(ContentType.Application.Json)
        }.body()
        return response.todos
    }

    override suspend fun getTodoById(id: Int): Todo {
        val response: Todo = ktorClient.request("${HttpRoutes.TODOS}/$id") {
            method = HttpMethod.Get
            contentType(ContentType.Application.Json)
            accept(ContentType.Application.Json)
        }.body()
        return response
    }

    override suspend fun addTodo(todo: Todo): Todo {
        val response: Todo = ktorClient.request(HttpRoutes.TODOS) {
            method = HttpMethod.Post
            contentType(ContentType.Application.Json)
            accept(ContentType.Application.Json)
            body = todo
        }.body()
        return response
    }

    override suspend fun updateTodo(todo: Todo): Todo {
        val response: Todo = ktorClient.request("${HttpRoutes.TODOS}/${todo.id}") {
            method = HttpMethod.Put
            contentType(ContentType.Application.Json)
            accept(ContentType.Application.Json)
            body = todo
        }.body()
        return response
    }

    override suspend fun deleteTodo(id: Int): Boolean {
        val response: String = ktorClient.request("${HttpRoutes.TODOS}/$id") {
            method = HttpMethod.Delete
        }.toString()
        return response == "OK"
    }
}
