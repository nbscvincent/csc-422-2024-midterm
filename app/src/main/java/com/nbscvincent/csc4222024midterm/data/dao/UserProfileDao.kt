package com.nbscvincent.csc4222024midterm.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.nbscvincent.csc4222024midterm.model.UserProfile
import kotlinx.coroutines.flow.Flow

@Dao
interface UserProfileDao {
    @Query("SELECT * from user ORDER BY username ASC")
    fun getAllUsers(): Flow<List<UserProfile>>

    @Query("SELECT * from user WHERE username = :username")
    fun getUsers(username: String): Flow<UserProfile>

    @Query("SELECT * FROM user WHERE username = :username AND password = :password")
    fun getUsersPass(username: String, password: String): Flow<UserProfile>

}