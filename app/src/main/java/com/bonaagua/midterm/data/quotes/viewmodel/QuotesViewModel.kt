package com.bonaagua.midterm.data.quotes.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bonaagua.midterm.data.quotes.model.Quote
import com.bonaagua.midterm.data.quotes.repository.QuoteRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class QuotesViewModel(private val quoteRepository: QuoteRepository) : ViewModel() {
    var quotesList by mutableStateOf<List<Quote>>(emptyList())
    var randomQuote by mutableStateOf<Quote?>(null)

    suspend fun getQuotes() {
        try {
            val quotes = quoteRepository.getQuotes()
            quotesList = quotes
            Log.i("", "quotesList $quotesList")
        } catch (e: Exception) {
            Log.e("", "Failed to fetch quotes: ${e.message}", e)
        }
    }

    suspend fun getRandomQuote() {
        try {
            val randomId = (0..100).random() // Generate a random ID
            randomQuote = quoteRepository.getQuoteById(randomId)
        } catch (e: Exception) {
            Log.e("", "Failed to fetch random quote: ${e.message}", e)
        }
    }
}