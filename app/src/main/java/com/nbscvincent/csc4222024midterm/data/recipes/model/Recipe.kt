package com.nbscvincent.csc4222024midterm.data.recipes.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Recipe(
    @SerialName("id") val id: Int,
    @SerialName("name") val name: String,
    @SerialName("ingredients") val ingredients: List<String>,
    @SerialName("instructions") val instructions: List<String>,
    @SerialName("prepTimeMinutes") val prepTimeMinutes: Int,
    @SerialName("cookTimeMinutes") val cookTimeMinutes: Int,
    @SerialName("servings") val servings: Int,
    @SerialName("difficulty") val difficulty: String,
    @SerialName("cuisine") val cuisine: String,
    @SerialName("caloriesPerServing") val caloriesPerServing: Int,
    @SerialName("tags") val tags: List<String>,
    @SerialName("userId") val userId: Int,
    @SerialName("image") val image: String,
    @SerialName("rating") val rating: Double,
    @SerialName("reviewCount") val reviewCount: Int,
    @SerialName("mealType") val mealType: List<String>
)
