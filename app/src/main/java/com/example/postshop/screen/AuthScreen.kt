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
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.postshop.R

@Composable
fun AuthScreen(modifier: Modifier=Modifier){
    Column(
        modifier= Modifier
            .fillMaxSize()
            .padding(32.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.banner),
            contentDescription = "",
            modifier= Modifier.fillMaxWidth()
                .height(200.dp)
        )
        Spacer(modifier= Modifier.height(20.dp))
        Text(text = "Welcome to PostShop",
                style = TextStyle(
                    fontSize = 30.sp,
                    fontFamily = FontFamily.Monospace,
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.Center
                )
            )
        Text(text = "The best shop of all time",
              style = TextStyle(
                  textAlign = TextAlign.Center
              )
            )
        Spacer(modifier=Modifier.height(25.dp))

        Button(
                onClick = {/*TODO*/},
                modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Login", fontSize = 22.sp)
        }
        Spacer(modifier=Modifier.height(15.dp))

        OutlinedButton(
            onClick = {/*TODO*/},
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Signup", fontSize = 22.sp)
        }
    }
}