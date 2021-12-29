package com.getnow.getnowxratings.data

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.mutableStateListOf

@Immutable
data class Quote(
    val quoteContent: String,
    val likes: Int,
)

class User(val name: String){
    private var quotes = mutableStateListOf<Quote>()

    fun addQuote(quote: String, likes: Int){
        quotes.add(Quote(quote, likes))
    }

    fun getQuotes(): MutableList<Quote> {
        return quotes
    }

}

object MockData {
    val users: List<User> = listOf(
        User("Tomasz Bułat"),
        User("Janusz Kowalski"),
        User("John Smith")
    )
}