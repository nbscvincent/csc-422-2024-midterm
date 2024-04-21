package com.nbscvincent.csc4222024midterm.data.dao

import androidx.room.Dao
import androidx.room.Query

@Dao
interface RecipesDao {
    @Query("SELECT * from recipes ORDER BY id ASC")
    fun getAllRecipes(): String

}