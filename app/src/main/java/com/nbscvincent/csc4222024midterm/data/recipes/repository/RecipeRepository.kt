package com.nbscvincent.csc4222024midterm.data.recipes.repository

import com.nbscvincent.csc4222024midterm.data.recipes.model.Recipe

interface RecipeRepository {
    suspend fun getRecipes(): List<Recipe>

    suspend fun getRecipeById(id: Int): Recipe

    suspend fun addRecipe(quote: Recipe): Recipe

    suspend fun updateRecipe(quote: Recipe): Recipe

    suspend fun deleteRecipe(id: Int): Boolean
}
