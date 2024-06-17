package com.example.myproject.repository

import com.example.myproject.model.LoginModel

interface LoginRepository {
    fun addEmail(loginModel: LoginModel, callback :(Boolean, String?) -> Unit)
    fun addPassword(loginModel: LoginModel,callback : (Boolean,String?)-> Unit)
}