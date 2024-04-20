package com.nbscvincent.csc4222024midterm.data.offlineRepository


import com.nbscvincent.csc4222024midterm.data.dao.UserProfileDao
import com.nbscvincent.csc4222024midterm.data.repository.UserRepository
import com.nbscvincent.csc4222024midterm.model.Credentials
import com.nbscvincent.csc4222024midterm.model.UserProfile
import kotlinx.coroutines.flow.Flow

class OfflineUserRepository(private val userDao: UserProfileDao) : UserRepository {

    override suspend fun login(user: Credentials): Flow<UserProfile?> = userDao.getUsersPass(user.username, user.password)
}