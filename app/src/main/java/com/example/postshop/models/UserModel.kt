package com.example.postshop.models

data class UserModel (
    val email:String="" ,
    val name:String="",
    val uid:String="",
    val cartItems: Map<String,Long> = emptyMap()
)