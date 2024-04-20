package com.nbscvincent.csc4222024midterm.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.nbscvincent.csc4222024midterm.model.ToDo

@Dao
interface ToDoDao {
    @Query("SELECT * from todo ORDER BY id ASC")
    fun getAllToDo(): List<ToDo>


}