package com.nbscvincent.csc4222024midterm.data.onlineRepository

import com.nbscvincent.csc4222024midterm.data.network.HttpRoutes
import com.nbscvincent.csc4222024midterm.data.network.KtorClient
import com.nbscvincent.csc4222024midterm.data.repository.RecipesRepository
import com.nbscvincent.csc4222024midterm.data.repository.ToDoRepository
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.accept
import io.ktor.client.request.request
import io.ktor.client.request.url
import io.ktor.http.ContentType
import io.ktor.http.HttpMethod
import io.ktor.http.contentType

class OnlineRecipesRepository (private val ktorClient: HttpClient = KtorClient()): RecipesRepository {

    override suspend fun getRecipes(): String {

        val response: String = ktorClient.request(HttpRoutes.recipes) {
            method = HttpMethod.Get
            url(HttpRoutes.recipes)
            contentType(ContentType.Application.Json)
            accept(ContentType.Application.Json)

        }.body()
        return response
    }
}