package com.example.postshop.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.postshop.pages.CartPage
import com.example.postshop.pages.FavoritePage
import com.example.postshop.pages.HomePage
import com.example.postshop.pages.ProfilePage
import com.google.firebase.Firebase
import com.google.firebase.auth.auth

@Composable
fun HomeScreen(modifier:Modifier=Modifier,
               navController:NavController){
    val navItemList = listOf(
        NavItem("Home", Icons.Default.ShoppingCart),
        NavItem("Favorite",Icons.Default.Favorite),
        NavItem("Cart",Icons.Default.ShoppingCart),
        NavItem("Profile", Icons.Default.Person)
    )
    var selectedIndex by remember {
        mutableStateOf(0)
    }
    Scaffold(
        bottomBar = {
            NavigationBar {
                navItemList.forEachIndexed{index, navItem->
                    NavigationBarItem(
                        selected = index == selectedIndex,
                        onClick = {
                            selectedIndex = index
                        },
                        icon={
                            Icon(navItem.icon, contentDescription = navItem.label)
                        },
                        label = {
                            Text(text = navItem.label)
                        }
                    )
                }
            }
        }
    ) {
        ContentScreen(modifier=modifier.padding(it),selectedIndex)
    }

}

@Composable
fun ContentScreen(modifier: Modifier = Modifier,selectedItem:Int){
    when(selectedItem){
        0-> HomePage()
        1-> FavoritePage()
        2-> CartPage()
        3-> ProfilePage()
    }

}

data class NavItem(
    val label: String,
    val icon:ImageVector
)