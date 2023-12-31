package com.caiorocha.app_praca

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.caiorocha.app_praca.ui.HomeScreen
import com.caiorocha.app_praca.ui.MainScreen
import com.caiorocha.app_praca.ui.theme.ApppracaTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ApppracaTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()

                    NavHost(navController = navController, startDestination = "home") {
                        composable("home") {
                            HomeScreen(navigateToMainScreen = { navController.navigate("main") })
                        }
                        composable("main") {
                            MainScreen (navigateToHomeScreen = { navController.navigate("home") })
                        }
                    }
                }
            }
        }
    }
}







