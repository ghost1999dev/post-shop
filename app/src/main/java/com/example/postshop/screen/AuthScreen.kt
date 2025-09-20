package com.example.postshop.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.postshop.R

@Composable
fun AuthScreen(modifier: Modifier = Modifier, navController: NavHostController){
    Column (
        modifier= Modifier
            .fillMaxSize()
            .padding(32.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Image(
            painter = painterResource(id=R.drawable.banner),
            contentDescription = "Banner image",
            modifier = Modifier.fillMaxWidth()
                               .height(200.dp)
        )
        Text(text = "Welcome to PostShop",
             style = TextStyle(
                 fontSize = 24.sp,
                 fontWeight = FontWeight.SemiBold,
                 textAlign = TextAlign.Center
             )
            )
        Spacer(modifier= Modifier.height(8.dp))
        Text(text = "The best place to buy clothes", fontSize = 15.sp)

        Spacer( modifier= Modifier.height(15.dp))
        Button(
            onClick = {
                navController.navigate("login")
            },
            modifier= Modifier
                .fillMaxWidth()
                .height(50.dp)
            ) {
            Text(text = "Login", fontSize = 20.sp)
        }
        Spacer( modifier= Modifier.height(10.dp))
        OutlinedButton(
            onClick = {
                navController.navigate("signup")
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Text(text="Signup", fontSize = 20.sp)
        }
    }
}