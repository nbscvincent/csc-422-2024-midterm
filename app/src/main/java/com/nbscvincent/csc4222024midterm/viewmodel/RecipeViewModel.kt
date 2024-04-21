package com.nbscvincent.csc4222024midterm.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.nbscvincent.csc4222024midterm.data.repository.RecipesRepository
import com.nbscvincent.csc4222024midterm.data.repository.ToDoRepository
import timber.log.Timber

class RecipeViewModel(private val recipesRepository: RecipesRepository): ViewModel() {
    var recipesUiState by mutableStateOf(RecipesUiState())

    suspend fun getRecipes() {
        val recipes = recipesRepository.getRecipes()
        recipesUiState =
            RecipesUiState(recipes = recipes)
        Timber.i("postsUiState $recipesUiState")
    }

    data class RecipesUiState(
        var recipes: String = ""
    )
}
