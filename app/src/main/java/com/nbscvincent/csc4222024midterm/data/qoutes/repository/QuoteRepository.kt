package com.nbscvincent.csc4222024midterm.data.qoutes.repository

import com.nbscvincent.csc4222024midterm.data.qoutes.model.Quote

interface QuoteRepository {
    suspend fun getQuotes(): List<Quote>
    suspend fun getQuoteById(id: Int): Quote
    suspend fun addQuote(quote: Quote): Quote
    suspend fun updateQuote(quote: Quote): Quote
    suspend fun deleteQuote(id: Int): Boolean
}
