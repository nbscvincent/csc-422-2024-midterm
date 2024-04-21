package com.nbscvincent.csc4222024midterm.model

import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Serializable
data class Recipes(
    val id: Int,
    val name: String,
    val ingredients: String,
)

