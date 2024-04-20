package com.nbscvincent.csc4222024midterm.data.onlineRepository

import com.nbscvincent.csc4222024midterm.data.network.HttpRoutes
import com.nbscvincent.csc4222024midterm.data.network.KtorClient
import com.nbscvincent.csc4222024midterm.data.repository.UserRepository
import com.nbscvincent.csc4222024midterm.model.Credentials
import com.nbscvincent.csc4222024midterm.model.UserProfile
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.accept
import io.ktor.client.request.forms.MultiPartFormDataContent
import io.ktor.client.request.forms.formData
import io.ktor.client.request.request
import io.ktor.client.request.setBody
import io.ktor.client.request.url
import io.ktor.http.ContentType
import io.ktor.http.HttpMethod
import io.ktor.http.contentType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class OnlineUserRepository(private val ktorClient: HttpClient = KtorClient() ) : UserRepository {


    // login
    override suspend fun login(user: Credentials): Flow<UserProfile?> {
        val cl = ktorClient.request(
            HttpRoutes.login
        ) {
            method = HttpMethod.Get
            url(HttpRoutes.login)
            contentType(ContentType.Application.Json)
            accept(ContentType.Application.Json)
            setBody(user)
        }
        return flow {
            emit(cl.body())
        }
    }
    // end login

}