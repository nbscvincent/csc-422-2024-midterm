package com.nbscvincent.csc4222024midterm.data.onlineRepository

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.nbscvincent.csc4222024midterm.data.network.HttpRoutes
import com.nbscvincent.csc4222024midterm.data.network.KtorClient
import com.nbscvincent.csc4222024midterm.model.Credentials
import com.nbscvincent.csc4222024midterm.model.LoginResonse
import com.nbscvincent.csc4222024midterm.model.LoginResponse
import com.nbscvincent.csc4222024midterm.model.ResponseQoutes
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.accept
import io.ktor.client.request.forms.MultiPartFormDataContent
import io.ktor.client.request.forms.formData
import io.ktor.client.request.request
import io.ktor.client.request.setBody
import io.ktor.client.request.url
import io.ktor.client.statement.bodyAsText
import io.ktor.http.ContentType
import io.ktor.http.HttpMethod
import io.ktor.http.contentType
import kotlinx.serialization.Serializable


class OnlineUserRepository(private val ktorClient: HttpClient = KtorClient()) {
        suspend fun login(username: String, password: String): List<LoginResonse> {
            var data = mutableStateListOf<LoginResonse>()
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

                    data.add(LoginResonse(0, "Success"))
                } else {
                    data.add(LoginResonse(1, "Invalid credentials"))
                }
            } catch (e: Exception) {
                data.add(LoginResonse(1, "Invalid credentials"))
            }
            return data
        }
}




