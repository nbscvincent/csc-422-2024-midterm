package com.miguel.midterm.repository.onlinerepository

import com.miguel.midterm.dataclass.Quote

interface QuoteRepository {

    // Retrieve quotes randomly
    suspend fun getQuotes(): List<Quote>

    suspend fun getQuoteById(id: Int): Quote

    suspend fun addQuote(quote: Quote): Quote

    suspend fun updateQuote(quote: Quote): Quote

    suspend fun deleteQuote(id: Int): Boolean
}
