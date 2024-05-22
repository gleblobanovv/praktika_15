package com.example.praktika_15_lobanov

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.EditText
import android.widget.Toast

class RegisterActivity : AppCompatActivity() {
    private lateinit var password: EditText
    private lateinit var login1: EditText
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        password = findViewById(R.id.password)
        login1 = findViewById(R.id.login)
    }

    fun goToQuest(view: View){
        if(login1.text.toString().isNotEmpty() && password.text.toString().isNotEmpty()){
            if (login1.text.toString()=="ekts"){
                if (password.text.toString()=="ekts2024"){
                    val intent= Intent(this,SplashScreen::class.java)
                    startActivity(intent)
                }else{
                    val toast=Toast.makeText(this,"Неправильный пароль",Toast.LENGTH_LONG)
                    toast.setGravity(Gravity.CENTER,0,0)
                    toast.show()
                }
            }else{
                val toast=Toast.makeText(this,"Неправильный логин",Toast.LENGTH_LONG)
                toast.setGravity(Gravity.CENTER,0,0)
                toast.show()
            }
        }else{
            val toast=Toast.makeText(this,"Есть незаполненные поля",Toast.LENGTH_LONG)
            toast.setGravity(Gravity.CENTER,0,0)
            toast.show()
        }
    }
}