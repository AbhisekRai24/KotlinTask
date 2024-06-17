package com.example.myproject.ui.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myproject.R
import com.example.myproject.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    lateinit var loginBinding: ActivityLoginBinding
    var auth : FirebaseAuth = FirebaseAuth.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        loginBinding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(loginBinding.root)

        loginBinding.buttonLog.setOnClickListener {
            var email : String = loginBinding.editTextemail.text.toString()
            var password : String = loginBinding.editTextpassword.text.toString()
            auth.signInWithEmailAndPassword(email,password).
            addOnCompleteListener {
                if(it.isSuccessful){
                    Toast.makeText(applicationContext,
                        "Login success", Toast.LENGTH_LONG).show()
                    //navigate to dashboard
                    var intent = Intent(this@LoginActivity,
                        DashboardActivity::class.java)
                    startActivity(intent)
                }else{
                    Toast.makeText(applicationContext,
                        it.exception?.message, Toast.LENGTH_LONG).show()
                }
            }
        }

        loginBinding.textRegister.setOnClickListener {
            var intent = Intent(this@LoginActivity,
                ForgetActivity::class.java)
            startActivity(intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}