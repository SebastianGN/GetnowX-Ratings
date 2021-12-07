package com.getnow.getnowxratings

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import com.getnow.getnowxratings.ui.theme.GetnowXRatingsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GetnowXRatingsTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Scaffold(
                        Modifier.fillMaxSize(), 
                        topBar = {
                            TopAppBar(
                                modifier = Modifier.fillMaxWidth(),
                                title = { Text(text = "GetnowX - Ratings") },
                                actions = {
                                    IconButton(onClick = { /*TODO*/ }) {
                                        Icon(Icons.Filled.Menu, contentDescription = "MENU", modifier = Modifier.size(40.dp))
                                    }
                                },
                                backgroundColor = Color(ContextCompat.getColor(this, R.color.getnowgreen)),
                                contentColor = Color.White
                            )
                        },
                        bottomBar = {
                            BottomAppBar(Modifier.fillMaxWidth(), backgroundColor = Color(ContextCompat.getColor(this, R.color.getnowgreen)), contentColor = Color.White) {
                                val navs = listOf<Navs>(Navs.Monsters, Navs.Quotes, Navs.SandwichShop, Navs.Sneeze, Navs.Tales)
                                navs.forEach() {
                                    BottomNavigationItem(
                                        selected = false,
                                        onClick = { /*TODO*/ },
                                        icon = { Icon(Icons.Filled.Menu, contentDescription = null)}
                                    )
                                }
                            }
                        }
                    ) {
                        Greeting("Android")
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GetnowXRatingsTheme {
        Greeting("Android")
    }
}