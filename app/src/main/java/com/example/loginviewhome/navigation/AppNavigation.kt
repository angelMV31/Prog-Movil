package com.example.loginviewhome.navigation
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.loginviewhome.screen.Greeting
import com.example.loginviewhome.screen.LoginScreen
import com.example.loginviewhome.screen.MainScreen
import com.example.loginviewhome.screen.Register


@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "main"
    ) {
        composable("welcome") {
            Greeting(navController)
        }
        composable("login") {
            LoginScreen(navController)
        }
        composable("register") {
            Register(navController)
        }
        composable("main"){
            MainScreen(navController)
        }
    }
}

