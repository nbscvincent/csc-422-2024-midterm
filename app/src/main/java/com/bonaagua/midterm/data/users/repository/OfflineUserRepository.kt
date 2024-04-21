package com.bonaagua.midterm.data.users.repository

import com.bonaagua.midterm.data.users.model.User

class OfflineUserRepository (private val userDao: UserDao) {
    suspend fun saveUserToLocalDatabase(user: User) {
        userDao.insert(user)
    }
}