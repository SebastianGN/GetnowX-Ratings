package com.getnow.getnowxratings

sealed class Navs(val routeName: String, val title: String) {
    object Sneeze: Navs("Sneeze", "Sneeze")
    object Monsters: Navs("Monsters", "Monsters")
    object Tales: Navs("Tales", "Tales")
    object SandwichShop: Navs("SandwichShop", "SandwichShop")
    object Quotes: Navs("Quotes", "Quotes")
}
