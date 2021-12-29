package com.getnow.getnowxratings

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.getnow.getnowxratings.screens.*
import com.getnow.getnowxratings.ui.theme.GetnowXRatingsTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            GetnowXRatingsTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                   AppMain()
                }
            }
        }
    }
}

@Composable
fun AppMain() {
    val navs = listOf(Navs.Monsters, Navs.Quotes, Navs.SandwichShop, Navs.Sneeze, Navs.Tales)
    val navController = rememberNavController()
    var currRoute by rememberSaveable {
        mutableStateOf(Navs.Monsters.routeName)
    }
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    Scaffold(
        Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                modifier = Modifier.fillMaxWidth(),
                title = { Text(text = "GetnowX - Ratings") },
                backgroundColor = Color(LocalContext.current.getColor(R.color.getnowgreen)),
                contentColor = Color.White,
                navigationIcon = {
                    IconButton(onClick = { scope.launch {
                        scaffoldState.drawerState.open()
                    } }) {
                        if (scaffoldState.drawerState.isOpen) {
                            Icon(Icons.Filled.Close, contentDescription = "Close", modifier = Modifier.size(40.dp))
                        } else {
                            Icon(Icons.Filled.Menu, contentDescription = "MENU", modifier = Modifier.size(40.dp))
                        }
                    }
                }
            )
        },
        bottomBar = {
            BottomAppBar(
                Modifier.fillMaxWidth(),
                backgroundColor = Color(LocalContext.current.getColor(R.color.getnowgreen)),
                contentColor = Color.White) {
                navs.forEach {
                    BottomNavigationItem(
                        selected = currRoute == it.routeName,
                        onClick = { navController.navigate(it.routeName); currRoute = it.routeName },
                        icon = { Icon(painter = painterResource(id = it.icon), contentDescription = it.title, modifier = Modifier.size(30.dp)) }
                    )
                }
            }
        },
        drawerContent = {
            Column(Modifier.fillMaxSize()) {
                Text(text = "DUPA")
            }
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { println("floating button has been clicked") }) {
                Icon(Icons.Filled.Edit, contentDescription = "menu")
            }
        },
        scaffoldState = scaffoldState
    ) { innerPadding ->
//        Box(modifier = Modifier
//            .fillMaxSize()
//            .padding(top = it.calculateTopPadding(), bottom = it.calculateBottomPadding())) {
            NavHost(
                navController = navController,
                startDestination = Navs.Monsters.routeName,
                modifier = Modifier.padding(innerPadding)
            ) {

                composable(Navs.Quotes.routeName) {
//                    MainViewContent(rememberNavController.currentBackStackEntry!!.destination.route!!).Content()
                    QuotesBody()
                }
                composable(Navs.Monsters.routeName){
                    MonstersBody()
                }
                composable(Navs.Sneeze.routeName){
                    SneezeBody()
                }
                composable(Navs.Tales.routeName){
                    TalesBody()
                }
                composable(Navs.SandwichShop.routeName){
                    SandwichShopBody()
                }

            }
//        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GetnowXRatingsTheme {
        AppMain()
    }
}