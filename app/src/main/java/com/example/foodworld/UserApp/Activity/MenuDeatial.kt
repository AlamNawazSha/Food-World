package com.example.foodworld.UserApp.Activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.foodworld.R
import com.example.foodworld.databinding.ActivityMenuDeatialBinding

class MenuDeatial : AppCompatActivity() {
    private lateinit var binding : ActivityMenuDeatialBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuDeatialBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val foodName = intent.getStringExtra("ItemName")
        val foodPrice = intent.getStringExtra("ItemPrice")
        val foodImg = intent.getIntExtra("ItemImg",0)

        binding.deatialFoodName.text=foodName
        binding.FoodPrice.text=foodPrice
        binding.foodImg.setImageResource(foodImg)
    }
}