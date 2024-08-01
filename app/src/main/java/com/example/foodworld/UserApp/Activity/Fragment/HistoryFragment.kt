package com.example.foodworld.UserApp.Activity.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodworld.UserApp.Activity.Adapter.HistoryAdapter
import com.example.foodworld.R
import com.example.foodworld.databinding.FragmentCartBinding
import com.example.foodworld.databinding.FragmentHistoryBinding

class HistoryFragment : Fragment() {
private lateinit var binding: FragmentHistoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
      binding = FragmentHistoryBinding.inflate(layoutInflater,container,false)

        val item = listOf("Burger","sandwich","mom","item")
        val price = listOf("₹100","₹500","₹200","₹50")
        val img = listOf(
            R.drawable.menu1,
            R.drawable.menu2,
            R.drawable.menu3,
            R.drawable.menu4,
        )

        val adapter = HistoryAdapter(ArrayList(item), ArrayList(price), ArrayList(img))
        binding.historyPreviouslyBuyRv.layoutManager = LinearLayoutManager(requireContext())
        binding.historyPreviouslyBuyRv.adapter =adapter
        return binding.root
    }

    companion object {
    }
}