package com.bonaagua.midterm.data.quotes.model

import kotlinx.serialization.Serializable

@Serializable
data class Quote(
    val id: Int,
    val quote: String,
    val author: String
)