package com.nbscvincent.csc4222024midterm.data.offlineRepository

import com.nbscvincent.csc4222024midterm.data.dao.ToDoDao
import com.nbscvincent.csc4222024midterm.data.repository.RecipesRepository

class OfflineRecipesRepository(private val toDoDao: ToDoDao) : RecipesRepository {
    override suspend fun getRecipes(): String {
        return toDoDao.getAllToDo()
    }

}