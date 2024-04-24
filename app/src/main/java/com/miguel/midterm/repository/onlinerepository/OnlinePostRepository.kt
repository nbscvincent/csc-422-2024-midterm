package com.miguel.midterm.repository.onlinerepository

import com.miguel.midterm.dataclass.Post
import com.miguel.midterm.network.HttpRoutes
import com.miguel.midterm.network.ktorClient
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.accept
import io.ktor.client.request.request
import io.ktor.client.request.url
import io.ktor.http.ContentType
import io.ktor.http.HttpMethod
import io.ktor.http.contentType

class OnlinePostRepository (private val ktorClient: HttpClient = ktorClient()): PostRepository {

    override suspend fun getPosts(): List<Post> {

        val response: List<Post> = ktorClient.request(HttpRoutes.POSTS) {
            method = HttpMethod.Get
            url(HttpRoutes.POSTS)
            contentType(ContentType.Application.Json)
            accept(ContentType.Application.Json)
        }.body()
        return response
    }
}