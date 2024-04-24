package com.miguel.midterm.repository.onlinerepository

import com.miguel.midterm.dataclass.Recipe

interface RecipeRepository {

    // Retrieve all recipes
    suspend fun getRecipes(): List<Recipe>

    suspend fun getRecipeById(id: Int): Recipe

    suspend fun addRecipe(quote: Recipe): Recipe

    suspend fun updateRecipe(quote: Recipe): Recipe

    suspend fun deleteRecipe(id: Int): Boolean
}
