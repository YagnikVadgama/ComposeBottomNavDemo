package com.yudiz.bottomnavdemo

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@ExperimentalAnimationApi
@Composable
fun MainFunc(
    route: String,
    onItemSelected: (Screens) -> Unit
) {
    val item = Screens.Items.items

    Row(
        modifier = Modifier
            .background(MaterialTheme.colors.background)
            .padding(8.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {

        item.forEach {item ->
            CustomBottomNavigationItem(item = item, isSelected = item.route== route) {
                onItemSelected(item)
            }
        }
    }
}

@ExperimentalAnimationApi
@Composable
fun CustomBottomNavigationItem(item: Screens, isSelected: Boolean, onClick: () -> Unit) {

    val background =
        if (isSelected) MaterialTheme.colors.primary.copy(alpha = 0.1f) else Color.Transparent
    val contextColor =
        if (isSelected) MaterialTheme.colors.primary else MaterialTheme.colors.onBackground

    Box(
        modifier = Modifier
            .clip(CircleShape)
            .background(background)
            .clickable(onClick = onClick)
    ) {
        Row(
            modifier = Modifier
                .padding(12.dp),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(
                imageVector = item.icon,
                contentDescription = null,
                tint = contextColor
            )

            AnimatedVisibility(visible = isSelected) {
                Text(
                    text = item.label,
                    color = contextColor
                )
            }
        }
    }
}

@Composable
fun ScreenController(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "Home") {
        composable("Home") {
            Home()
        }
        composable("Profile") {
            Profile()
        }
        composable("Offers") {
            Offers()
        }
        composable("Contact") {
            Contact()
        }
    }
}

@ExperimentalAnimationApi
@Composable
@Preview
fun Prev1() {
    MainFunc(route = Screens.Home.route) {
    }
}

@ExperimentalAnimationApi
@Composable
@Preview
fun Prev2() {
    CustomBottomNavigationItem(item = Screens.Home, isSelected = true) {
    }
}

@Composable
fun Home() {
    Text(
        text = "Home",
        textAlign = TextAlign.Center,
        style = TextStyle(color = Color.White, fontSize = 30.sp)
    )
}

@Composable
fun Profile() {
    Text(
        text = "Profile",
        textAlign = TextAlign.Center,
        style = TextStyle(color = Color.Black, fontSize = 30.sp)
    )
}

@Composable
fun Offers() {
    Text(
        text = "Offers",
        textAlign = TextAlign.Center,
        style = TextStyle(color = Color.White, fontSize = 30.sp)
    )
}

@Composable
fun Contact() {
    Text(
        text = "Contact",
        textAlign = TextAlign.Center,
        style = TextStyle(color = Color.Black, fontSize = 30.sp)
    )
}