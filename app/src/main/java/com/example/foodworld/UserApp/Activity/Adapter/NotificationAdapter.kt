package com.example.foodworld.UserApp.Activity.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.foodworld.databinding.NotificatinItemsBinding

class NotificationAdapter(private val message : List<String>, private val img : List<Int>):RecyclerView.Adapter<NotificationAdapter.NotificationViewHolder> (){
    override fun onCreateViewHolder(parent: ViewGroup,viewType: Int): NotificationViewHolder {
       return NotificationViewHolder(NotificatinItemsBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: NotificationViewHolder, position: Int) {
      holder.bind(position)
    }

    override fun getItemCount(): Int {
        return message.size
    }
   inner class NotificationViewHolder(private val binding: NotificatinItemsBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.apply {
                notifiMessg.text = message[position]
                notifiImg.setImageResource(img[position])
            }
        }

    }

}