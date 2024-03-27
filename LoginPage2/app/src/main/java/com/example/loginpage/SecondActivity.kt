package com.example.loginpage

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondActivity : AppCompatActivity() {
    private lateinit var newUsernameEditText: EditText
    private lateinit var newPasswordEditText: EditText
    private lateinit var saveButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)

        newUsernameEditText = findViewById(R.id.newUsernameEditText)
        newPasswordEditText = findViewById(R.id.newPasswordEditText)
        saveButton = findViewById(R.id.saveButton)

        saveButton.isEnabled = false

        val textWatcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                saveButton.isEnabled = newUsernameEditText.text.isNotEmpty() && newPasswordEditText.text.isNotEmpty()
            }
            override fun afterTextChanged(s: Editable?) {}
        }

        newUsernameEditText.addTextChangedListener(textWatcher)
        newPasswordEditText.addTextChangedListener(textWatcher)

        saveButton.setOnClickListener {
            val sharedPreferences = getSharedPreferences("LoginPrefs", Context.MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.putString("username", newUsernameEditText.text.toString())
            editor.putString("password", newPasswordEditText.text.toString())
            editor.apply()
            AlertDialog.Builder(this)
                .setMessage("Credenciais atualizadas com sucesso!")
                .setPositiveButton("OK") { dialog, which ->
                    finish()
                }
                .show()
        }

//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
    }
}