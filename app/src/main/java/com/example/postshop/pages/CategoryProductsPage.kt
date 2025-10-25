package com.example.postshop.pages

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun CategoryProductsPage(modifier: Modifier=Modifier,categoryId:String?){

    Text("This is category ${categoryId}")

}