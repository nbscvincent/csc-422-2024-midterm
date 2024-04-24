package com.miguel.midterm.response

import com.miguel.midterm.dataclass.Recipe
import kotlinx.serialization.Serializable

@Serializable
data class RecipeResponse(
    val recipes: List<Recipe>,
    val total: Int,
    val skip: Int,
    val limit: Int
)