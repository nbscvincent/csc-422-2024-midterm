package com.nbscvincent.csc4222024midterm.data.onlineRepository

import androidx.compose.runtime.mutableStateListOf
import com.nbscvincent.csc4222024midterm.data.network.HttpRoutes
import com.nbscvincent.csc4222024midterm.data.network.KtorClient
import com.nbscvincent.csc4222024midterm.model.Credentials
import com.nbscvincent.csc4222024midterm.model.LoginResponse
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


class OnlineUserRepository(private val ktorClient: HttpClient = KtorClient() )  {
    suspend fun checkLogin(username: String, password: String): List<LoginResponse> {
        var data = mutableStateListOf<LoginResponse>()
        try {
            val req = ktorClient.request(
                HttpRoutes.login
            ) {
                method = HttpMethod.Post
                url(HttpRoutes.login)
                contentType(ContentType.Application.Json)
                accept(ContentType.Application.Json)
                setBody(MultiPartFormDataContent(formData {
                    append("username", username)
                    append("password", password)
                }))
            }

            if (req.status.toString() == "200 OK") {
                val response = req.body<Credentials>()

                data.add(LoginResponse(0, "Success"))
            } else {
                data.add(LoginResponse(1, "Invalid credentials"))
            }
        } catch (e: Exception) {
            data.add(LoginResponse(1, "Invalid credentials"))
        }
        return data


    }
}