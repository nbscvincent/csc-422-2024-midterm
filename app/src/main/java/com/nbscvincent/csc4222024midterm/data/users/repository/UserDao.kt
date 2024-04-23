package com.nbscvincent.csc4222024midterm.data.users.repository

import com.nbscvincent.csc4222024midterm.data.users.model.User

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(user: User)

    @Update
    suspend fun update(user: User)

    @Delete
    suspend fun delete(user: User)

    @Query("Select * FROM User")
    suspend fun getAllUsers() : List<User>

    @Query("Select * FROM User WHERE id = :id")
    suspend fun getUserById(id: Int) : User
}

