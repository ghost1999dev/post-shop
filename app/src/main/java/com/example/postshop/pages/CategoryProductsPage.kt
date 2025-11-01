package com.example.postshop.pages
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.postshop.models.ProductModel
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore

@Composable
fun CategoryProductsPage(modifier: Modifier=Modifier,categoryId:String?){

    val productList = remember {
        mutableStateOf<List<ProductModel>>(emptyList())
    }

    //Get information from firebase
    LaunchedEffect(key1=Unit) {
        Firebase.firestore.collection("data").document("stock")
            .collection("products")
            .whereEqualTo("category",categoryId)
            .get().addOnCompleteListener {
                if(it.isSuccessful){
                    val resultList = it.result.documents.mapNotNull { doc->
                        doc.toObject(ProductModel::class.java)
                    }
                    productList.value = resultList
                }
            }
    }

    LazyColumn(
        modifier = Modifier.fillMaxSize()
            .padding(17.dp)
    ) {
        items(productList.value){item->
            Text(text = item.title)
        }
    }
}