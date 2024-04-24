package com.miguel.midterm.repository.offlinerepository

import com.miguel.midterm.dataclass.User

class OfflineUserRepository (private val userDao: UserDao) {
    suspend fun saveUserToLocalDatabase(user: User) {
        userDao.insert(user)
    }
}