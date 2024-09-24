package com.example.layoutloginscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class HelloUser : AppCompatActivity() {
    private lateinit var buttonBack: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hello_user)

        buttonBack = findViewById(R.id.buttonBack)

        buttonBack.setOnClickListener {
            // Inicie a MainActivity ao clicar no botão de voltar
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish() // Encerra a HelloWorldActivity para que não volte a ela
        }
    }
}