package com.nbscvincent.csc4222024midterm.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable
@Entity(tableName = "todo")
@Serializable
data class ToDo(
    @PrimaryKey var id: Int,
    val todo: String,
    val completed: Boolean,
    val userID: Int
)

