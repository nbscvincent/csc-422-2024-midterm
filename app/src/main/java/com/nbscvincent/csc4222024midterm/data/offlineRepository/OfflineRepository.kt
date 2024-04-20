package com.nbscvincent.csc4222024midterm.data.offlineRepository

import com.nbscvincent.csc4222024midterm.data.dao.ToDoDao
import com.nbscvincent.csc4222024midterm.data.repository.ToDoRepository
import com.nbscvincent.csc4222024midterm.model.ToDo

class OfflinePostRepository(private val toDoDao: ToDoDao ) : ToDoRepository {
    override suspend fun getToDo(): List<ToDo> {
        return toDoDao.getAllToDo()
    }

}