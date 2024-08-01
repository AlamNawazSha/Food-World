package com.example.foodworld.UserApp.Activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.foodworld.R
import com.example.foodworld.UserApp.Activity.Fragment.CompeletFragment
import com.example.foodworld.databinding.ActivityPaymentBinding

class PaymentActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPaymentBinding
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPaymentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val name = binding.paymnetName
        val address = binding.paymnetAddress
        val phoneNumber = binding.paymnetNumber
        binding.placeOrderBtn.setOnClickListener {
            if (name.equals("") && address.equals("") && phoneNumber.equals("")) {
                Toast.makeText(this, "Enter the Complete details", Toast.LENGTH_SHORT).show()

        }else{
                val dialog = CompeletFragment()
                dialog.show(supportFragmentManager, "Test")

            }
    }
        binding.paymentBackBtn.setOnClickListener {
            finish()
        }
        }
    }
