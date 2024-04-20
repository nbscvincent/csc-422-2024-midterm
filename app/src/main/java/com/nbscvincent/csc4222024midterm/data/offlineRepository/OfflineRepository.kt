package com.nbscvincent.csc4222024midterm.data.offlineRepository


import com.nbscvincent.csc4222024midterm.data.dao.UserProfileDao
import com.nbscvincent.csc4222024midterm.data.network.HttpRoutes
import com.nbscvincent.csc4222024midterm.data.network.KtorClient
import com.nbscvincent.csc4222024midterm.data.repository.UserRepository
import com.nbscvincent.csc4222024midterm.model.UserProfile
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.accept
import io.ktor.client.request.forms.MultiPartFormDataContent
import io.ktor.client.request.forms.formData
import io.ktor.client.request.request
import io.ktor.client.request.setBody
import io.ktor.client.request.url
import io.ktor.http.ContentType
import io.ktor.http.HttpMethod
import io.ktor.http.contentType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


class OfflineUserRepository(private val userDao: UserProfileDao) : UserRepository {
    override fun getAllUsersStream(): Flow<List<UserProfile>> = userDao.getAllUsers()
    override suspend fun getUserStream(id: String): Flow<UserProfile?> = userDao.getUsers(id)
    override suspend fun getUserPasswordStream(username: String, password: String): Flow<UserProfile?> = userDao.getUsersPass(username, password)

}