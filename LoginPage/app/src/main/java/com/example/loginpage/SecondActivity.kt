package com.example.loginpage

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity


class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val newUsernameEditText: EditText = findViewById(R.id.newUsername)
        val newPasswordEditText: EditText = findViewById(R.id.newPassword)
        val saveButton: Button = findViewById(R.id.saveButton)

        saveButton.setOnClickListener {
            val newUsername = newUsernameEditText.text.toString().trim()
            val newPassword = newPasswordEditText.text.toString().trim()

            if (newUsername.isBlank() || newPassword.isBlank()) {
                AlertDialog.Builder(this)
                    .setTitle("Erro")
                    .setMessage("Todos os campos devem ser preenchidos.")
                    .setPositiveButton("OK", null)
                    .show()
            } else {
                updateCredentials(newUsername, newPassword)
            }
        }
    }

    private fun updateCredentials(newUsername: String, newPassword: String) {
        val sharedPrefs = getSharedPreferences("Login", Context.MODE_PRIVATE)
        val editor = sharedPrefs.edit()

        // Aqui você pode querer verificar se o novoUsername já existe e tratar isso de acordo.
        // Para simplificar, estamos apenas atualizando as credenciais.

        editor.putString(newUsername, "$newPassword|user") // Assume "user" como tipo padrão. Adapte conforme necessário.
        editor.apply()

        AlertDialog.Builder(this)
            .setTitle("Sucesso")
            .setMessage("Credenciais atualizadas com sucesso!")
            .setPositiveButton("OK") { _, _ ->
                finish() // Retorna para a LoginActivity ou onde quer que seja apropriado
            }
            .show()
    }
}
