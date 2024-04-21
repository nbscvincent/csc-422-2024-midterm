package com.nbscvincent.csc4222024midterm.data.repository

interface RecipesRepository {

    // Retrieve all posts
    suspend fun getRecipes(): String

}