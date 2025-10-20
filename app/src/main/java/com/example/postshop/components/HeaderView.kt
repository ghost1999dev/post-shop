package com.example.postshop.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.runtime.setValue
import androidx.compose .runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.firestore

@Composable
fun HeaderView(modifier: Modifier = Modifier){
    var name by remember {
        mutableStateOf("")
    }

    //I need get info from firebase
    LaunchedEffect(Unit) {
        var currentUser = FirebaseAuth.getInstance().currentUser
        currentUser?.uid?.let { currentId->
            Firebase.firestore.collection("users")
                .whereEqualTo("uid",currentId)
                .get().addOnCompleteListener{task->
                    if(task.isSuccessful){
                        val documentSnapshot = task.result.documents.firstOrNull()
                        if(documentSnapshot !=null){
                            val fullName =documentSnapshot.getString("name")
                            name = fullName ?:"Name not found"
                        }else{
                            name = "Name is empty"
                        }
                    }else{
                        name = "Server error"
                    }
                }
        }?: run{
            name = "There is not session "
        }
    }

    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween

    ) {
        Column {
            Text(
                "Welcome back",
                style = TextStyle(
                    fontSize =25.sp,
                    fontWeight = FontWeight.Bold
                )
            )
            Text(
                name,
                style = TextStyle(
                    fontSize = 18.sp
                )

            )

        }
        IconButton(
            onClick = {}
        ) {
            Icon(imageVector = Icons.Default.Search, contentDescription = "Search")
        }
    }
}