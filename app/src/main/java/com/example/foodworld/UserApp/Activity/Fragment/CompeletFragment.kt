package com.example.foodworld.UserApp.Activity.Fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.foodworld.databinding.FragmentCompeletBinding

class CompeletFragment : DialogFragment() {
private lateinit var binding: FragmentCompeletBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
  binding = FragmentCompeletBinding.inflate(inflater,container,false)
        return binding.root
    }

    companion object {

    }
}