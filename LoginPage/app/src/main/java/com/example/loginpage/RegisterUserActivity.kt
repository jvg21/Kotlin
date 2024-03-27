package com.example.loginpage

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.content.Context
import android.content.Intent
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class RegisterUserActivity : AppCompatActivity() {
    private lateinit var usernameEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var confirmPasswordEditText: EditText
    private lateinit var userTypeSpinner: Spinner
    private lateinit var registerButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_user)

        usernameEditText = findViewById(R.id.usernameEditText)
        passwordEditText = findViewById(R.id.passwordEditText)
        confirmPasswordEditText = findViewById(R.id.confirmPasswordEditText)
        userTypeSpinner = findViewById(R.id.userTypeSpinner)
        registerButton = findViewById(R.id.registerButton)

        setupUserTypeSpinner()
        setupRegisterButton()
    }

    private fun setupUserTypeSpinner() {
        ArrayAdapter.createFromResource(
            this,
            R.array.user_types, // Define no res/values/strings.xml
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            userTypeSpinner.adapter = adapter
        }
    }

    private fun setupRegisterButton() {
        registerButton.setOnClickListener {
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()
            val confirmPassword = confirmPasswordEditText.text.toString()
            val userType = userTypeSpinner.selectedItem.toString()

            if (validateInput(username, password, confirmPassword)) {
                if (saveUserCredentials(username, password, userType)) {
                    AlertDialog.Builder(this)
                        .setTitle("Sucesso")
                        .setMessage("Usuário cadastrado com sucesso!")
                        .setPositiveButton("OK") { _, _ ->
                            startActivity(Intent(this, MainActivity::class.java))
                            finish()
                        }
                        .show()
                } else {
                    AlertDialog.Builder(this)
                        .setTitle("Erro")
                        .setMessage("Username já existe.")
                        .setPositiveButton("OK", null)
                        .show()
                }
            }
        }
    }

    private fun validateInput(username: String, password: String, confirmPassword: String): Boolean {
        if (username.isBlank() || password.isBlank() || confirmPassword.isBlank()) {
            showToast("Todos os campos devem ser preenchidos")
            return false
        }

        if (password != confirmPassword) {
            showToast("As senhas não coincidem")
            return false
        }

        return true
    }

    private fun saveUserCredentials(username: String, password: String, userType: String): Boolean {
        val sharedPrefs = getSharedPreferences("Login", Context.MODE_PRIVATE)
        val existingUser = sharedPrefs.getString(username, null)

        if (existingUser != null) {
            return false
        }

        with(sharedPrefs.edit()) {
            putString(username, "$password|$userType")
            apply()
        }

        return true // Usuário cadastrado com sucesso
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
