package com.bonaagua.midterm.data.users.repository

import com.bonaagua.midterm.data.users.model.User
import com.bonaagua.midterm.data.users.model.UserResponse
import com.bonaagua.midterm.network.HttpRoutes
import com.bonaagua.midterm.network.KtorClient
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.accept
import io.ktor.client.request.request
import io.ktor.client.request.url
import io.ktor.client.statement.HttpResponse
import io.ktor.http.ContentType
import io.ktor.http.HttpMethod
import io.ktor.http.contentType
import io.ktor.util.InternalAPI

@OptIn(InternalAPI::class)
class OnlineUserRepository(private val ktorClient: HttpClient = KtorClient()) : UserRepository {

    override suspend fun getUsers(): List<User> {
        val response: UserResponse = ktorClient.request(HttpRoutes.USERS) {
            method = HttpMethod.Get
            url(HttpRoutes.USERS)
            contentType(ContentType.Application.Json)
            accept(ContentType.Application.Json)
        }.body()
        return response.users
    }

    override suspend fun getUserById(id: Int): User {
        val response: User = ktorClient.request("${HttpRoutes.USERS}/$id") {
            method = HttpMethod.Get
            contentType(ContentType.Application.Json)
            accept(ContentType.Application.Json)
        }.body()
        return response
    }

    override suspend fun addUser(user: User): User {
        val response: User = ktorClient.request(HttpRoutes.USERS) {
            method = HttpMethod.Post
            contentType(ContentType.Application.Json)
            accept(ContentType.Application.Json)
            body = user
        }.body()
        return response
    }

    override suspend fun updateUser(user: User): User {
        val response: User = ktorClient.request("${HttpRoutes.USERS}/${user.id}") {
            method = HttpMethod.Put
            contentType(ContentType.Application.Json)
            accept(ContentType.Application.Json)
            body = user
        }.body()
        return response
    }

    override suspend fun deleteUser(id: Int): Boolean {
        val response: String = ktorClient.request("${HttpRoutes.QUOTES}/$id") {
            method = HttpMethod.Delete
        }.toString()
        return response == "OK"
    }

    override suspend fun getUserByUsernameAndPassword(username: String, password: String): User? {
        val response: HttpResponse = ktorClient.request(HttpRoutes.USERS)
        val userResponse: UserResponse = response.body<UserResponse>()

        return userResponse.users.find { it.username == username && it.password == password }
    }
}
