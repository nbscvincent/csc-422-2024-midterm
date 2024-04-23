package com.nbscvincent.csc4222024midterm.data.users.repository

import com.nbscvincent.csc4222024midterm.data.users.model.User

class OfflineUserRepository (private val userDao: UserDao) {
    suspend fun saveUserToLocalDatabase(user: User) {
        userDao.insert(user)
    }
}
