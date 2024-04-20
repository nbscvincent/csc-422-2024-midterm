package com.nbscvincent.csc4222024midterm.model

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.nbscvincent.csc4222024midterm.network.HttpRoutes
import com.nbscvincent.csc4222024midterm.network.KtorClient
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
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.serialization.Serializable
import java.util.Calendar

class ScreenViewModel : ViewModel() {
    private val _isLogin = MutableStateFlow(false)
    val isLogin = _isLogin.asStateFlow()

    fun checkLogin(): Boolean {
        return _isLogin.value
    }
    fun setLogin(){
        _isLogin.value = true;
    }
    fun unsetLogin(){
        _isLogin.value = false;
    }
}

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

    suspend fun greeting(): String {
        var msg = ""

        val calendarTime = Calendar.getInstance()

        val time = calendarTime.get(Calendar.HOUR_OF_DAY)
        when(time){
            in 6..11 -> msg = "Good Morning"
            in 12..17 -> msg = "Good Afternoon"
            in 18..22 -> msg = "Good Evening"
            else -> msg = "Good Morning"
        }
        return msg
    }

    suspend fun getQoutes() : String {
        var quote: String = ""
        try {
            val req = ktorClient.request(
                HttpRoutes.quotes
            ){
                method = HttpMethod.Get
                url(HttpRoutes.quotes)
                contentType(ContentType.Application.Json)
                accept(ContentType.Application.Json)
            }

            println("SAMPLE" + req.status)
            println("SAMPLE" + req.bodyAsText())

            //if (req.status.toString() == "200 OK"){
                //val response = req.body<ResponseQoutes>()

                /*quote[0].id = response.id
                quote[0].quote = response.quote
                quote[0].author = response.author*/
            //}

        } catch (e: Exception){
            println("SAMPLE ERROR $e")
            //data.add(LoginReturn(1,"Invalid credentials"))
        }
        return quote
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

@Serializable
data class ResponseQoutes(
    var id: Int,
    var quote: String,
    var author: String,
)