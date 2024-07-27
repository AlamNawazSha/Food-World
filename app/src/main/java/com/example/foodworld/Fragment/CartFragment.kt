package com.example.foodworld.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodworld.Adapter.CartAdapter
import com.example.foodworld.R
import com.example.foodworld.databinding.FragmentCartBinding

class CartFragment : Fragment() {
lateinit var binding: FragmentCartBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCartBinding.inflate(inflater,container,false)
        val item = listOf("Burger","sandwich","mom","item")
        val price = listOf("₹100","₹500","₹200","₹50")
        val img = listOf(
            R.drawable.menu1,
            R.drawable.menu2,
            R.drawable.menu3,
            R.drawable.menu4,
        )

        val adapter = CartAdapter(ArrayList(item),ArrayList(price),ArrayList(img))
        binding.cartRv.layoutManager = LinearLayoutManager(requireContext())
        binding.cartRv.adapter = adapter
        return binding.root

    }

    companion object {

    }
}