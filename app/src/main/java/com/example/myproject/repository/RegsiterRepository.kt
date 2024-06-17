package com.example.myproject.repository

import com.example.myproject.model.LoginModel
import com.example.myproject.model.RegisterModel

interface RegsiterRepository {

    fun addEmail(registerModel: RegisterModel, callback :(Boolean, String?) -> Unit)
    fun addPassword(registerModel: RegisterModel, callback : (Boolean, String?)-> Unit)

    fun addName(regsiterModel: RegisterModel,callback :(Boolean,String?)-> Unit)
}