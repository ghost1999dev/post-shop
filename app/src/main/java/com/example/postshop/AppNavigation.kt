package com.example.postshop

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.postshop.screen.AuthScreen
import com.example.postshop.screen.LoginScreen
import com.example.postshop.screen.SignupScreen


@Composable
fun AppNavigation(modifier: Modifier=Modifier){
    val navController = rememberNavController()

    NavHost(navController=navController, startDestination = "auth") {
        composable("auth"){
            AuthScreen(modifier,navController)
        }
        composable("login"){
            LoginScreen(modifier,navController)
        }
        composable("signup"){
            SignupScreen(modifier)
        }

    }
}