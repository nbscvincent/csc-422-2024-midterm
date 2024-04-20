package com.nbscvincent.csc4222024midterm.data.offlineRepository


import com.nbscvincent.csc4222024midterm.data.dao.UserProfileDao
import com.nbscvincent.csc4222024midterm.data.repository.UserRepository
import com.nbscvincent.csc4222024midterm.model.UserProfile
import kotlinx.coroutines.flow.Flow

class OfflineUserRepository(private val userDao: UserProfileDao) : UserRepository {
    override fun getAllUsersStream(): Flow<List<UserProfile>> = userDao.getAllUsers()
    override suspend fun getUserStream(username: String): Flow<UserProfile?> = userDao.getUsers(username)
    override suspend fun getUserPasswordStream(username: String, password: String): Flow<UserProfile?> = userDao.getUsersPass(username, password)
    override suspend fun insertUser(user: UserProfile) = userDao.insert(user)
    override suspend fun deleteUser(user: UserProfile) = userDao.delete(user)
    override suspend fun updateUser(user: UserProfile) = userDao.update(user)
}