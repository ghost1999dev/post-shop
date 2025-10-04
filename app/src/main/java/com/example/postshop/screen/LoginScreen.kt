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
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.postshop.R
import com.example.postshop.utils.AppUtil
import com.example.postshop.viewmodel.AuthViewModel

@Composable
fun LoginScreen(modifier: Modifier = Modifier,
                navController: NavHostController,
                viewModel: AuthViewModel= viewModel()
){
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isLoading by remember { mutableStateOf(false) }
    var context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Welcome to login",
             modifier =  modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            style = TextStyle(
                fontSize = 35.sp,
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.Bold
            )
        )
        Spacer(modifier=Modifier.height(15.dp))
        Image(
            painter = painterResource(id=R.drawable.userlogin),
            contentDescription = "Login screen",
            modifier = Modifier.fillMaxWidth().height(200.dp)
        )
        OutlinedTextField(
            value = email,
            onValueChange = {
                email=it
            },
            label = {
                Text("Email addres")
            },
            modifier= Modifier.fillMaxWidth()
        )
        Spacer(modifier= Modifier.height(10.dp))
        OutlinedTextField(
            value= password,
            onValueChange = {
                password = it
            },
            label = {
                Text("Password")
            },
            modifier = Modifier.fillMaxWidth(),
            visualTransformation = PasswordVisualTransformation()
        )
        Spacer(modifier = Modifier.height(20.dp))
        Button (
            onClick = {
                isLoading = true
                viewModel.login(
                    email,
                    password
                ){success,message->
                    if(success){
                        isLoading = false
                        navController.navigate("home")
                    }else{
                        isLoading=true
                        AppUtil.showToast(context,message?:"Something went error")
                    }
                }
            },
            enabled =  !isLoading,
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Text(text = if(isLoading) "Loggin in" else
                "Login", fontSize = 20.sp )
        }

    }
}