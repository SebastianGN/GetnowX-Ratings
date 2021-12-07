package com.getnow.getnowxratings

sealed class Navs(val routeName: String, val title: String, val icon: Int) {
    object Sneeze: Navs("Sneeze", "Sneeze", icon = R.drawable.sneeze_icon)
    object Monsters: Navs("Monsters", "Monsters", icon = R.drawable.monsters_icon)
    object Tales: Navs("Tales", "Tales", icon = R.drawable.tales_icon)
    object SandwichShop: Navs("SandwichShop", "SandwichShop", icon = R.drawable.sshop_icon)
    object Quotes: Navs("Quotes", "Quotes", icon = R.drawable.quotes_icon)
}
