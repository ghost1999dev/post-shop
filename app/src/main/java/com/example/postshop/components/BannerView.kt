package com.example.postshop.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore


@Composable
fun BannerView(
    modifier:Modifier=Modifier
){
    var bannerList by remember {
        mutableStateOf<List<String>>(emptyList())
    }

    LaunchedEffect(Unit) {
        Firebase.firestore.collection("data")
            .document("banners")
            .get().addOnCompleteListener{
                bannerList = it.result.get("urls") as List<String>
            }
    }

    Column {
        val pageState = rememberPagerState (0){
            bannerList.size
        }
        HorizontalPager(
            state = pageState
        ) {
            AsyncImage(
                model = bannerList.get(it),
                contentDescription = "Banner Image",
                modifier =Modifier.fillMaxWidth()
                    .clip(RoundedCornerShape(16.dp))

            )
        }
    }
}