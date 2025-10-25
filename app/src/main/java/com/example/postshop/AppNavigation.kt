package com.example.postshop

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.postshop.pages.CategoryProductsPage
import com.example.postshop.screen.AuthScreen
import com.example.postshop.screen.HomeScreen
import com.example.postshop.screen.LoginScreen
import com.example.postshop.screen.SignupScreen
import com.google.firebase.Firebase
import com.google.firebase.auth.auth

@Composable
fun AppNavigation(modifier: Modifier=Modifier){
    val navController = rememberNavController()
    GlobalNavigation.navController = navController
    var isLogged = Firebase.auth.currentUser!=null
    var firstPage = if(isLogged) "home" else "auth"
    NavHost(navController=navController, startDestination = firstPage) {
        composable("auth"){
            AuthScreen(modifier,navController)
        }
        composable("login"){
            LoginScreen(modifier,navController)
        }
        composable("signup"){
            SignupScreen(modifier,navController)
        }
        composable("home"){
            HomeScreen(modifier,navController)
        }
        composable("category-products/{categoryId}"){
            val categoryId = it.arguments?.getString("categoryId")
            CategoryProductsPage(modifier, categoryId)
        }



    }
}
object GlobalNavigation{
    lateinit var navController:NavHostController
}

