package com.example.layoutloginscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar

class HelloUser : AppCompatActivity() {
    private lateinit var buttonBack: Button
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hello_user)

        buttonBack = findViewById(R.id.buttonBack)
        progressBar = findViewById(R.id.progressBar)

        showLoading(true)
        Handler(Looper.getMainLooper()).postDelayed({
            showLoading(false) // Esconde o loading após a simulação
        }, 2000)

        buttonBack.setOnClickListener {
            // Inicie a MainActivity ao clicar no botão de voltar
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish() // Encerra a HelloWorldActivity para que não volte a ela
        }
    }

    private fun showLoading(isLoading: Boolean) {
        if (isLoading) {
            progressBar.visibility = View.VISIBLE
        } else {
            progressBar.visibility = View.GONE
        }
    }
}