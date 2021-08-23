package com.yudiz.bottomnavdemo

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screens(val route: String, val label: String, val icon: ImageVector) {
    object Home : Screens("Home", "Home", Icons.Default.Home)
    object Profile : Screens("Profile", "Profile", Icons.Default.Person)
    object Offers : Screens("Offers", "Offers", Icons.Default.AccountBox)
    object Contact : Screens("About", "About", Icons.Default.Call)

    object Items{
        val items = listOf(
            Home,Profile,Offers,Contact
        )
    }
}