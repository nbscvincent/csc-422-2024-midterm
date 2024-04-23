package com.nbscvincent.csc4222024midterm.data.qoutes.model

import kotlinx.serialization.Serializable

@Serializable
data class QuoteResponse(
    val quotes: List<Quote>,
    val total: Int,
    val skip: Int,
    val limit: Int
)
