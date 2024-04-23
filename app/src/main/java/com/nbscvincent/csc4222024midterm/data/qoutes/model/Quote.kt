package com.nbscvincent.csc4222024midterm.data.qoutes.model

import kotlinx.serialization.Serializable

@Serializable
data class Quote(
    val id: Int,
    val quote: String,
    val author: String
)
