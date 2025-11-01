package com.example.postshop.models

data class ProductModel (
    val actualPrice:String= "",
    val category:String = "",
    val description:String = "",
    val id:String ="",
    val images:List<String> = emptyList(),
    val price:String = "",
    val title:String= ""
)