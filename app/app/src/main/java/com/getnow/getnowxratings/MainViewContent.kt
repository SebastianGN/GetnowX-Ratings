package com.getnow.getnowxratings

import androidx.compose.material.Text
import androidx.compose.runtime.Composable

class MainViewContent(val routName: String) {
    @Composable
    fun Content() {
        Text(text = "ROUTE $routName")
    }
}
