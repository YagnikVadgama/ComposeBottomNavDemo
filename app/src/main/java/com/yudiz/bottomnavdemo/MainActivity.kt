package com.yudiz.bottomnavdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.yudiz.bottomnavdemo.ui.theme.BottomNavDemoTheme

class MainActivity : ComponentActivity() {
    @ExperimentalAnimationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val navController = rememberNavController()
            val currentScreen = mutableStateOf<Screens>(Screens.Home)

            BottomNavDemoTheme {
                Surface(color = MaterialTheme.colors.background) {
                    Scaffold(
                        bottomBar = {
                            MainFunc(route = currentScreen.value.route) {
                                currentScreen.value = it
                            }
                        }
                    ) {
                        ScreenController(navController = navController)
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BottomNavDemoTheme {

    }
}