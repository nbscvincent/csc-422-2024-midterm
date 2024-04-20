package com.nbscvincent.csc4222024midterm.data.repository

import com.nbscvincent.csc4222024midterm.model.Credentials
import com.nbscvincent.csc4222024midterm.model.UserProfile
import kotlinx.coroutines.flow.Flow

interface UserRepository {

    suspend fun login(user: Credentials): Flow<UserProfile?>

}