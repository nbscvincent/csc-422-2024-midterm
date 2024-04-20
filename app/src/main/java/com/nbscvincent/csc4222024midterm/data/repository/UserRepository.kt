package com.nbscvincent.csc4222024midterm.data.repository

import com.nbscvincent.csc4222024midterm.model.UserProfile
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    /**
     * Retrieve all the users from the the given data source.
     */
    fun getAllUsersStream(): Flow<List<UserProfile>>

    /**
     * Retrieve an user from the given data source that matches with the [id].
     */
    suspend fun getUserStream(id: String): Flow<UserProfile?>

    /**
     * Retrieve an user and password.
     */
    suspend fun getUserPasswordStream(username: String, password:String): Flow<UserProfile?>



}