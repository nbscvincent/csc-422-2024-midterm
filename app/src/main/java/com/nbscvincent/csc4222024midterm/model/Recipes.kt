package com.nbscvincent.csc4222024midterm.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Entity(tableName = "recipes")
@Serializable
data class Recipes(
    @PrimaryKey val id: Int,
    val name: String,
    val ingredients: String,
)

