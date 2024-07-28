package com.example.foodworld.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.foodworld.databinding.HistoryPreviousItemsBinding

class HistoryAdapter(private val historyFoodName : ArrayList<String>,private val historyFoodPrice : ArrayList<String>,private val historyFoodImg : ArrayList<Int>):RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryAdapter.HistoryViewHolder {
        return HistoryViewHolder(HistoryPreviousItemsBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: HistoryAdapter.HistoryViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return historyFoodName.size
    }

   inner class HistoryViewHolder(private val binding: HistoryPreviousItemsBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.apply {
                foodName.text = historyFoodName[position]
                foodPrice.text = historyFoodPrice[position]
                foodImg.setImageResource(historyFoodImg[position])
            }
        }

    }

}