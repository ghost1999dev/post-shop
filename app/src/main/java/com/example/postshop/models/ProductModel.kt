package com.example.postshop.models

data class ProductModel(
    val actualPrice:String="",
    val category:String="",
    val description:String="",
    val id:String="",
    val title:String="",
    val price:String ="",
    val images:List<String> = emptyList()
)