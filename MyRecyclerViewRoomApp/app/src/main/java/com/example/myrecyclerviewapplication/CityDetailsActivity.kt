package com.example.myrecyclerviewapplication

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import com.example.myrecyclerviewapplication.databinding.ActivityCityDetailsBinding

class CityDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCityDetailsBinding
    private var hasChanges = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_city_details)

        Singleton.citySelected?.apply {
            binding.nameEditText.setText(name)
            binding.populationEditText.setText(population.toString())
            binding.capitalCheckBox.isChecked = isCapital
        }

        binding.saveButton.setOnClickListener {
            saveCity()
        }

        // Adiciona listeners para detectar mudanças nos campos
        val changeListener = {
            hasChanges = true
        }
        binding.nameEditText.addTextChangedListener(SimpleTextWatcher(changeListener))
        binding.populationEditText.addTextChangedListener(SimpleTextWatcher(changeListener))
        binding.capitalCheckBox.setOnCheckedChangeListener { _, _ -> hasChanges = true }
    }

    private fun saveCity() {
        val name = binding.nameEditText.text.toString()
        val population = binding.populationEditText.text.toString().toIntOrNull() ?: 0
        val isCapital = binding.capitalCheckBox.isChecked

        if (Singleton.citySelected == null) {
            Singleton.add(City(0, name, population, isCapital))
        } else {
            Singleton.citySelected?.apply {
                this.name = name
                this.population = population
                this.isCapital = isCapital
                Singleton.update(this)
            }
        }
        hasChanges = false
        finish()
    }

    override fun onBackPressed() {
        if (hasChanges) {
            AlertDialog.Builder(this)
                .setTitle("Unsaved Changes")
                .setMessage("Do you want to exit without saving?")
                .setPositiveButton("Exit") { _, _ ->
                    super.onBackPressed()
                }
                .setNegativeButton("Continue", null)
                .show()
        } else {
            super.onBackPressed()
        }
    }
}

// Helper class to watch text changes
class SimpleTextWatcher(private val onTextChanged: () -> Unit) : android.text.TextWatcher {
    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        onTextChanged()
    }
    override fun afterTextChanged(s: android.text.Editable?) {}
}
