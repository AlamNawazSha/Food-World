package com.example.foodworld.UserApp.Activity.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodworld.UserApp.Activity.Adapter.NotificationAdapter
import com.example.foodworld.R
import com.example.foodworld.databinding.FragmentNotificationBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class NotificationFragment : BottomSheetDialogFragment(){
    private lateinit var binding: FragmentNotificationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentNotificationBinding.inflate(layoutInflater,container,false)
        val messg = listOf("Your order has been Canceled Successfully","Order has been taken by the driver","Congrats Your Order Placed")
        val img = listOf(
            R.drawable.background,
            R.drawable.addres,
            R.drawable.icon__2_
        )
        val adapter = NotificationAdapter(ArrayList(messg),ArrayList(img))
        binding.notifiRv.layoutManager = LinearLayoutManager(requireContext())
        binding.notifiRv.adapter = adapter
        binding.notifiBackBtn.setOnClickListener {
            dismiss()
        }
        return binding.root
    }

    companion object {

    }
}