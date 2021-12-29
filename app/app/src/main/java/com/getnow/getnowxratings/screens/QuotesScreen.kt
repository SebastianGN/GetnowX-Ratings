package com.getnow.getnowxratings.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.getnow.getnowxratings.data.MockData
import com.getnow.getnowxratings.data.User

@Composable
fun QuotesBody() {
    LazyColumn(){
        items(MockData.users){ user ->
            UserBody(user = user)
        }
    }
}

@Composable
fun UserBody(user: User) {
    val (quotes, setQuotes) = remember { mutableStateOf(user.getQuotes()) }
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)
        .background(Color.Gray)
        .clickable(
            onClick = {
                user.addQuote("hello", 15)
            }
        )){
        Text(text = user.name)
        for (quote in user.getQuotes()) {
            Text(text = quote.quoteContent)
        }
    }
}