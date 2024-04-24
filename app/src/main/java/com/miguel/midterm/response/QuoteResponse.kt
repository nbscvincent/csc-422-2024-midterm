package com.miguel.midterm.response

import com.miguel.midterm.dataclass.Quote
import kotlinx.serialization.Serializable

@Serializable
data class QuoteResponse(
    val quotes: List<Quote>,
    val total: Int,
    val skip: Int,
    val limit: Int
)