package com.example.myproject.repository

import com.example.myproject.model.LoginModel
import com.google.firebase.database.FirebaseDatabase

class LoginRepositoryImpl : LoginRepository{
    var firebaseDatabase: FirebaseDatabase = FirebaseDatabase.getInstance()
    var ref = firebaseDatabase.reference.child("users")
    override fun addEmail(loginModel: LoginModel, callback: (Boolean, String?) -> Unit) {



    }

    override fun addPassword(loginModel: LoginModel, callback: (Boolean, String?) -> Unit) {
        TODO("Not yet implemented")
    }
}