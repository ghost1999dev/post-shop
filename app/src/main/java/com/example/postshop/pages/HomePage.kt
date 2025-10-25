package com.example.postshop.pages
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.postshop.components.BannerView
import com.example.postshop.components.CategoriesView
import com.example.postshop.components.HeaderView



@Composable
fun HomePage(modifier: Modifier=Modifier,
             ){
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        //Firts component
        HeaderView(modifier)
        Spacer(modifier = Modifier.height(20.dp))
        //Second component
        BannerView(modifier)
        Spacer(modifier = Modifier.height(15.dp))
        Text(
            "Categories",
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
        )
        Spacer(modifier = Modifier.height(20.dp))
        //Third component
        CategoriesView(modifier)

    }


}

