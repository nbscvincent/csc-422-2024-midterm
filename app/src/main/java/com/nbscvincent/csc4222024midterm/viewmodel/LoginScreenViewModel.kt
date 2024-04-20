package com.nbscvincent.csc4222024midterm.viewmodel

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.nbscvincent.csc4222024midterm.data.network.HttpRoutes
import com.nbscvincent.csc4222024midterm.data.network.KtorClient
import com.nbscvincent.csc4222024midterm.data.onlineRepository.OnlineUserRepository
import com.nbscvincent.csc4222024midterm.model.Credentials
import com.nbscvincent.csc4222024midterm.model.LoginResponse
import com.nbscvincent.csc4222024midterm.navigation.routes.MainScreen
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


class LoginScreenViewModel(private val onlineUserRepository: OnlineUserRepository) : ViewModel() {

    suspend fun checkLogin(username: String, password: String, screenViewModel: ScreenViewModel, navController: NavController) {
        val loginData = onlineUserRepository.checkLogin(username, password)
        if (loginData[0].flag == 1){
            print("INVALID USERNAME AND PASSWORD")
        } else {
            screenViewModel.setLogin()
            navController.navigate(MainScreen.HomePage.name)
        }
    }
}

