package com.example.postshop.utils

import android.content.Context
import android.widget.Toast
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.firestore

object AppUtil {
    fun showToast(context:Context,message:String){
        Toast.makeText(context,message,Toast.LENGTH_LONG).show()
    }

    fun addToCart(context: Context, productId: String) {
        val user = FirebaseAuth.getInstance().currentUser
        if (user == null) {
            showToast(context, "Error: No hay usuario logueado")
            return
        }
        val db = Firebase.firestore
        val userDoc = db.collection("users").document(user.uid)

        userDoc.get().addOnSuccessListener { document ->
            val currentCart = document.get("cartItems") as? Map<String, Long> ?: emptyMap()
            val currentQuantity = currentCart[productId] ?: 0
            val newQuantity = currentQuantity + 1

            if (document.exists()) {

                val updates = mapOf("cartItems.$productId" to newQuantity)

                userDoc.update(updates)
                    .addOnSuccessListener {
                        showToast(context, "Carrito actualizado (+1)")
                    }
                    .addOnFailureListener { e ->
                        showToast(context, "Error actualizando: ${e.message}")
                    }

            } else {
                val newUserMap = hashMapOf(
                    "uid" to user.uid,
                    "name" to (user.displayName ?: "Usuario Sin Nombre"),
                    "email" to (user.email ?: ""),
                    "cartItems" to mapOf(productId to newQuantity)
                )

                userDoc.set(newUserMap)
                    .addOnSuccessListener {
                        showToast(context, "Usuario creado y producto agregado")
                    }
                    .addOnFailureListener { e ->
                        showToast(context, "Error creando usuario: ${e.message}")
                    }
            }

        }.addOnFailureListener { e ->

            showToast(context, "Error de conexión: ${e.message}")
        }
    }
}