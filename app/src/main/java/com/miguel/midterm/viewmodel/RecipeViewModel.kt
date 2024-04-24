package com.miguel.midterm.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.miguel.midterm.dataclass.Recipe
import com.miguel.midterm.repository.onlinerepository.RecipeRepository
import timber.log.Timber

class RecipeViewModel(private val recipeRepository: RecipeRepository) : ViewModel() {
    var recipeList by mutableStateOf<List<Recipe>>(emptyList())

    suspend fun getRecipes() {
        try {
            val recipes = recipeRepository.getRecipes()
            recipeList = recipes
            Timber.tag("").i("recipeList %s", recipeList)
        } catch (e: Exception) {
            Timber.tag("").e(e, "Failed to fetch recipes: %s", e.message)
        }
    }
}