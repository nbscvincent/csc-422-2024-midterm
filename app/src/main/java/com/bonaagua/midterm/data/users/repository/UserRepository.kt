package com.bonaagua.midterm.data.users.repository

import com.bonaagua.midterm.data.users.model.User

interface UserRepository {

    suspend fun getUsers(): List<User>

    suspend fun getUserById(id: Int): User

    suspend fun addUser(user: User): User

    suspend fun updateUser(user: User): User

    suspend fun deleteUser(id: Int): Boolean

    suspend fun getUserByUsernameAndPassword(username: String, password: String): User?
}
