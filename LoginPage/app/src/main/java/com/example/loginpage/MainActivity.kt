package com.example.loginpage

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val usernameEditText: EditText = findViewById(R.id.username)
        val passwordEditText: EditText = findViewById(R.id.password)
        val loginButton: Button = findViewById(R.id.loginButton)
        val cadastroButton: Button = findViewById(R.id.cadastroButton)

        loginButton.setOnClickListener {
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()

            if (checkCredentials(username, password)) {
                val intent = Intent(this, SecondActivity::class.java).apply {
                    putExtra("username", username)
                }
                startActivity(intent)
            } else {
                AlertDialog.Builder(this)
                    .setTitle("Erro")
                    .setMessage("Username ou Password incorretos!")
                    .setPositiveButton("OK", null)
                    .show()
            }
        }

        cadastroButton.setOnClickListener{
            val intent = Intent(this, RegisterUserActivity::class.java)
            startActivity(intent)
        }


    }

    private fun checkCredentials(username: String, password: String): Boolean {
        val sharedPrefs = getSharedPreferences("Login", MODE_PRIVATE)
        val userDetails = sharedPrefs.getString(username, null) ?: return false
        val savedPassword = userDetails.split("|")[0]
        return password == savedPassword
    }
}
