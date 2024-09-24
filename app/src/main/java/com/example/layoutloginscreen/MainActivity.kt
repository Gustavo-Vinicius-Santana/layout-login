package com.example.layoutloginscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var editTextEmail: EditText
    private lateinit var editTextPassword: EditText
    private lateinit var buttonLogin: Button

    // Defina um email e senha de exemplo
    private val validEmail = "usuario@exemplo.com"
    private val validPassword = "senha123"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextEmail = findViewById(R.id.editTextEmail)
        editTextPassword = findViewById(R.id.editTextPassword)
        buttonLogin = findViewById(R.id.buttonLogin)

        buttonLogin.setOnClickListener {
            val email = editTextEmail.text.toString().trim()
            val password = editTextPassword.text.toString()

            if (validateInput(email, password)) {
                authenticateUser(email, password)
            } else {
                Toast.makeText(this, "Por favor, preencha todos os campos.", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

    private fun validateInput(email: String, password: String): Boolean {
        return email.isNotEmpty() && password.isNotEmpty()
    }

    private fun authenticateUser(email: String, password: String) {
        if (email == validEmail && password == validPassword) {
            // Autenticação bem-sucedida
            Toast.makeText(this, "Login realizado com sucesso!", Toast.LENGTH_SHORT).show()

            // Inicie a próxima atividade
            val intent = Intent(this, HelloUser::class.java)
            startActivity(intent)
            finish() // Finaliza a LoginActivity para que o usuário não possa voltar
        } else {
            // Falha na autenticação
            Toast.makeText(this, "Email ou senha incorretos.", Toast.LENGTH_SHORT).show()
        }
    }
}

