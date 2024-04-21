package com.nbscvincent.csc4222024midterm.data.repository

import com.nbscvincent.csc4222024midterm.model.ToDo

interface ToDoRepository {

    // Retrieve all posts
    suspend fun getToDo(): String

}