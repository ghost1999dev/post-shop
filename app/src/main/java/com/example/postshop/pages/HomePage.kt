package com.example.postshop.pages
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

import com.example.postshop.components.BannerView
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

    }


}