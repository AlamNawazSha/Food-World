package com.example.foodworld.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodworld.Adapter.PopularAdapter
import com.example.foodworld.R
import com.example.foodworld.databinding.FragmentMenuBootomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class MenuBottomSheetFragment : BottomSheetDialogFragment() {
private lateinit var binding : FragmentMenuBootomSheetBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMenuBootomSheetBinding.inflate(inflater,container,false)
        val item = listOf("Burger","sandwich","mom","item")
        val price = listOf("₹100","₹500","₹200","₹50")
        val img = listOf(
            R.drawable.menu1,
            R.drawable.menu2,
            R.drawable.menu3,
            R.drawable.menu4,
        )
        val adapter = PopularAdapter(ArrayList(item),ArrayList(img),ArrayList(price))
        binding.viewMenuRv.layoutManager = LinearLayoutManager(requireContext())
        binding.viewMenuRv.adapter = adapter
        binding.backbtn.setOnClickListener {
            dismiss()
        }
       return binding.root
    }

    companion object {

    }
}