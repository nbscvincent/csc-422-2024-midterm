package com.miguel.midterm.viewmodel

import androidx.lifecycle.ViewModel
import com.miguel.midterm.dataclass.UserLogIn
import com.miguel.midterm.dataclass.UserLoggedIn
import com.miguel.midterm.dataclass.User
import com.miguel.midterm.repository.offlinerepository.OfflineUserRepository
import com.miguel.midterm.repository.onlinerepository.UserRepository
import timber.log.Timber

class UsersViewModel(
    private val userRepository: UserRepository,
    private val offlineUserRepository: OfflineUserRepository
) : ViewModel() {


    suspend fun LogInUser(username: String, password: String): User? {
        return try {
            val user = userRepository.getUserByUsernameAndPassword(username, password)
            user?.let {
                UserLoggedIn.setLoggedInUser(UserLogIn(it.id, it.firstName, it.lastName,it.maidenName, it.username, it.password, it.email, it.phone, it.image))

                offlineUserRepository.saveUserToLocalDatabase(it)
            }
            user
        } catch (e: Exception) {
            Timber.tag("").e(e, "Failed to validate user: %s", e.message)
            null
        }
    }
}