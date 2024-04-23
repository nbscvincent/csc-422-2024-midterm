package com.nbscvincent.csc4222024midterm.data.recipes.repository

import com.nbscvincent.csc4222024midterm.data.recipes.model.Recipe
import com.nbscvincent.csc4222024midterm.data.recipes.model.RecipeResponse
import com.nbscvincent.csc4222024midterm.network.HttpRoutes
import com.nbscvincent.csc4222024midterm.network.KtorClient
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
class OnlineRecipeRepository(private val ktorClient: HttpClient = KtorClient()) : RecipeRepository {


    override suspend fun getRecipes(): List<Recipe> {
        val response: RecipeResponse = ktorClient.request(HttpRoutes.RECIPES) {
            method = HttpMethod.Get
            url(HttpRoutes.RECIPES)
            contentType(ContentType.Application.Json)
            accept(ContentType.Application.Json)
        }.body()
        return response.recipes
    }


    override suspend fun getRecipeById(id: Int): Recipe {
        val response: Recipe = ktorClient.request("${HttpRoutes.RECIPES}/$id") {
            method = HttpMethod.Get
            contentType(ContentType.Application.Json)
            accept(ContentType.Application.Json)
        }.body()
        return response
    }


    override suspend fun addRecipe(quote: Recipe): Recipe {
        val response: Recipe = ktorClient.request(HttpRoutes.RECIPES) {
            method = HttpMethod.Post
            contentType(ContentType.Application.Json)
            accept(ContentType.Application.Json)
            body = quote
        }.body()
        return response
    }


    override suspend fun updateRecipe(quote: Recipe): Recipe {
        val response: Recipe = ktorClient.request("${HttpRoutes.RECIPES}/${quote.id}") {
            method = HttpMethod.Put
            contentType(ContentType.Application.Json)
            accept(ContentType.Application.Json)
            body = quote
        }.body()
        return response
    }


    override suspend fun deleteRecipe(id: Int): Boolean {
        val response: String = ktorClient.request("${HttpRoutes.RECIPES}/$id") {
            method = HttpMethod.Delete
        }.toString()
        return response == "OK"
    }
}
