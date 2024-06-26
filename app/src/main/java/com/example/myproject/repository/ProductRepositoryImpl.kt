package com.example.myproject.repository

import android.net.Uri
import com.example.myproject.model.ProductModel
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference

class ProductRepositoryImpl : ProductRepository {
    var firebaseDatabase : FirebaseDatabase = FirebaseDatabase.getInstance()
    var ref = firebaseDatabase.reference.child("products")

    var firebaseStorage: FirebaseStorage = FirebaseStorage.getInstance()
    var storageRef : StorageReference = firebaseStorage.reference.child("products")

    override fun uploadImage(
        imageName: String,
        imageUrl: Uri,
        callback: (Boolean, String?) -> Unit
    ) {
        TODO("Not yet implemented")
    }

    override fun addProduct(
        productModel: ProductModel,
        imageUri: Uri?,
        onResult: (Boolean) -> Unit
    ) {
        productModel.id = ref.push().key ?: ""
        if (imageUri != null) {
            val imageRef = storageRef.child(productModel.id)
            imageRef.putFile(imageUri).addOnSuccessListener {
                imageRef.downloadUrl.addOnSuccessListener { uri ->
                    productModel.imageUrl = uri.toString()
                    ref.child(productModel.id).setValue(productModel).addOnCompleteListener {
                        onResult(it.isSuccessful)
                    }
                }
            }.addOnFailureListener {
                onResult(false)
            }
        } else {
            ref.child(productModel.id).setValue(productModel).addOnCompleteListener {
                onResult(it.isSuccessful)
    }

    override fun getAllProduct(callback: (List<ProductModel>?, Boolean, String?) -> Unit) {
        TODO("Not yet implemented")
    }

    override fun updateProduct(
        id: String,
        data: MutableMap<String, Any>?,
        callback: (Boolean, String?) -> Unit
    ) {
        TODO("Not yet implemented")
    }

    override fun deleteData(id: String, callback: (Boolean, String?) -> Unit) {
        TODO("Not yet implemented")
    }

    override fun deleteImage(imageName: String, callback: (Boolean, String?) -> Unit) {
        TODO("Not yet implemented")
    }

        })
    }
}
