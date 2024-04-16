package com.example.myrecyclerviewapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myrecyclerviewapplication.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView<ActivityMainBinding>(
            this, R.layout.activity_main)
        Singleton.setContext(this)
        binding.mainRecyclerView.adapter =
            CityAdapter(object : CityAdapter.OnCityClickListener{
                override fun onCityClick(view: View, position: Int) {
                    Singleton.citySelected = Singleton.cities[position]
                    val intent = Intent(this@MainActivity,
                        CityDetailsActivity::class.java)
                    startActivity(intent)
                }

                override fun onCityLongClick(view: View, position: Int) {
                    val deletedCity = Singleton.cities[position]
                    Singleton.delete(deletedCity)
                    binding.
                    mainRecyclerView.
                    adapter?.notifyItemRemoved(position)

                    Snackbar.make(binding.root, "City deleted", Snackbar.LENGTH_LONG)
                        .setAction("UNDO CHANGES"){
                            Singleton.add(deletedCity)
                            binding.mainRecyclerView.adapter?.notifyItemInserted(position)
                        }.show()

                }
            })

        binding.mainRecyclerView.layoutManager =
            LinearLayoutManager(this)

        binding.addButton.setOnClickListener {
            Singleton.citySelected = null
            val intent = Intent(this,
                CityDetailsActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        binding.mainRecyclerView.adapter?.
                notifyDataSetChanged()
    }
}