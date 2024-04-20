package com.nbscvincent.csc4222024midterm.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.nbscvincent.csc4222024midterm.data.network.HttpRoutes
import com.nbscvincent.csc4222024midterm.data.network.KtorClient
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.accept
import io.ktor.client.request.forms.MultiPartFormDataContent
import io.ktor.client.request.forms.formData
import io.ktor.client.request.request
import io.ktor.client.request.setBody
import io.ktor.client.request.url
import io.ktor.client.utils.EmptyContent.contentType
import io.ktor.http.ContentType
import io.ktor.http.HttpMethod
import io.ktor.http.contentType
import kotlinx.serialization.Serializable

class AppScreenViewModel() : ViewModel() {
    private val ktorClient: HttpClient = KtorClient()
    suspend fun checkLogin(username:String, password:String) : List<LoginReturn> {
        var data = mutableStateListOf<LoginReturn>()
        try {
            val req = ktorClient.request(
                HttpRoutes.login
            ){
                method = HttpMethod.Post
                url(HttpRoutes.login)
                contentType(ContentType.Application.Json)
                accept(ContentType.Application.Json)
                setBody(MultiPartFormDataContent(formData {
                    append("username", username)
                    append("password", password)
                }))
            }

            if (req.status.toString() == "200 OK"){
                val response = req.body<ResponseLogin>()

                data.add(LoginReturn(0,"Success"))
            }else{
                data.add(LoginReturn(1,"Invalid credentials"))
            }
        } catch (e: Exception){
            data.add(LoginReturn(1,"Invalid credentials"))
        }
        return data
    }



}




data class LoginReturn(
    var flag: Int,
    val message: String
)
@Serializable
data class ResponseLogin(
    val id: Int,
    val username: String,
    val email: String,
    val firstName: String,
    val lastName: String,
    val gender: String,
    val image: String,
    val token: String,
)



