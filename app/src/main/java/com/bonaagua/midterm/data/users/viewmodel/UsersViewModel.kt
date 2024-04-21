package com.bonaagua.midterm.data.users.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.bonaagua.midterm.data.users.model.LoggedInUser
import com.bonaagua.midterm.data.users.model.LoggedInUserHolder
import com.bonaagua.midterm.data.users.model.User
import com.bonaagua.midterm.data.users.repository.OfflineUserRepository
import com.bonaagua.midterm.data.users.repository.UserRepository

class UsersViewModel(
    private val userRepository: UserRepository,
    private val offlineUserRepository: OfflineUserRepository
) : ViewModel() {
    var userList by mutableStateOf<List<User>>(emptyList())

    suspend fun getUsers() {
        try {
            val users = userRepository.getUsers()
            userList = users
            Log.i("", "userList $userList")
        } catch (e: Exception) {
            Log.e("", "Failed to fetch users: ${e.message}", e)
        }
    }

    suspend fun validateUser(username: String, password: String): User? {
        return try {
            val user = userRepository.getUserByUsernameAndPassword(username, password)
            user?.let {
                // Set the logged-in user as the LoggedInUser holder
                LoggedInUserHolder.setLoggedInUser(LoggedInUser(it.id, it.firstName, it.lastName, it.username, it.password, it.email, it.phone, it.image))
                // Save user data to local database
                offlineUserRepository.saveUserToLocalDatabase(it)
            }
            user
        } catch (e: Exception) {
            Log.e("", "Failed to validate user: ${e.message}", e)
            null
        }
    }
}