package com.miguel.midterm.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.miguel.midterm.dataclass.Quote
import com.miguel.midterm.repository.onlinerepository.QuoteRepository
import timber.log.Timber

class QuotesViewModel(private val quoteRepository: QuoteRepository) : ViewModel() {
    var quotesList by mutableStateOf<List<Quote>>(emptyList())
    var randomQuote by mutableStateOf<Quote?>(null)

    suspend fun getQuotes() {
        try {
            val quotes = quoteRepository.getQuotes()
            quotesList = quotes
            Timber.tag("").i("quotesList %s", quotesList)
        } catch (e: Exception) {
            Timber.tag("").e(e, "Failed to fetch quotes: %s", e.message)
        }
    }

    suspend fun getRandomQuote() {
        try {
            val randomId = (0..100).random() // Generate a random ID
            randomQuote = quoteRepository.getQuoteById(randomId)
        } catch (e: Exception) {
            Timber.tag("").e(e, "Failed to fetch random quote: %s", e.message)
        }
    }
}