package com.nbscvincent.csc4222024midterm.model

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
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
    var qoute = mutableStateOf("")

    private val _todoList = mutableStateListOf<TodoList>()
    val todoList: List<TodoList>
        get() = _todoList

    private val _recipesList = mutableStateListOf<RecipesList>()
    val recipesList: List<RecipesList>
        get() = _recipesList

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

    fun greeting(): String {
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

    public fun getQoutes(){
        viewModelScope.launch {
            try {
                val req = ktorClient.request(
                    HttpRoutes.quotes
                ) {
                    method = HttpMethod.Get
                    url(HttpRoutes.quotes)
                    contentType(ContentType.Application.Json)
                    accept(ContentType.Application.Json)
                }
                if (req.status.toString() == "200 OK") {
                    val response = req.body<ResponseQoutes>()
                    qoute.value = response.quote
                }
            } catch (e: Exception) {
            }
        }
    }

    public fun getTodos() {
        viewModelScope.launch {
            try {
                val req = ktorClient.request(
                    HttpRoutes.todos
                ) {
                    method = HttpMethod.Get
                    url(HttpRoutes.todos)
                    contentType(ContentType.Application.Json)
                    accept(ContentType.Application.Json)
                }

                println("SAMPLE" + req.status)
                println("SAMPLE" + req.bodyAsText())

                if (req.status.toString() == "200 OK") {
                    val response = req.body<TodoResponse>()
                    _todoList.clear()
                    _todoList.addAll(response.todos)

                    println("SAMPLE DISPLAY HERE MODEL" + _todoList)
                }
            } catch (e: Exception) {
                println("SAMPLE ERROR $e")
            }
        }
    }
    public fun getRecipes() {
        viewModelScope.launch {
            try {
                val req = ktorClient.request(
                    HttpRoutes.recipes
                ) {
                    method = HttpMethod.Get
                    url(HttpRoutes.recipes)
                    contentType(ContentType.Application.Json)
                    accept(ContentType.Application.Json)
                }

                println("SAMPLE" + req.status)
                println("SAMPLE" + req.bodyAsText())

                if (req.status.toString() == "200 OK") {
                    val response = req.body<RecipesResponse>()
                    _recipesList.clear()
                    _recipesList.addAll(response.recipes)

                    println("SAMPLE DISPLAY HERE MODEL" + _todoList)
                }
            } catch (e: Exception) {
                println("SAMPLE ERROR $e")
            }
        }
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

@Serializable
data class TodoList(
    var id: Int,
    var todo: String,
    var completed: Boolean,
    var userId: Int,
)
@Serializable
data class TodoResponse(
    var todos: List<TodoList>,
    var total: Int,
    var skip: String,
    var limit: Int,
)

@Serializable
data class RecipesList(
    var id: Int,
    var name: String,
    var ingredients: List<String>,
    var instructions: List<String>,
    var prepTimeMinutes: Int,
    var cookTimeMinutes: Int,
    var servings: Int,
    var difficulty: String,
    var cuisine: String,
    var caloriesPerServing: Int,
    var tags: List<String>,
    var userId: Int,
    var image: String,
    var rating: String,
    var reviewCount: Int,
    var mealType: List<String>,
)
@Serializable
data class RecipesResponse(
    var recipes: List<RecipesList>,
    var total: Int,
    var skip: String,
    var limit: Int,
)

