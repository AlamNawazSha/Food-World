package com.example.foodworld.UserApp.Activity.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.foodworld.databinding.MenuItemsBinding

class PopularAdapter(private val Items : MutableList<String> , private  val  Image:MutableList<Int>, private val Price : MutableList<String>) : RecyclerView.Adapter<PopularAdapter.PopularViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularViewHolder {
        return PopularViewHolder(MenuItemsBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: PopularViewHolder, position: Int) {
        val item = Items[position]
        val img = Image[position]
        val price = Price[position]
        holder.bind(item,img,price)
    }
    override fun getItemCount(): Int {
      return Items.size
    }
    class PopularViewHolder(private val binding:MenuItemsBinding) : RecyclerView.ViewHolder(binding.root) {
        private val imgView = binding.foodImg
        fun bind(item: String, img: Int, price: String) {
            binding.foodName.text = item
            binding.foodPrice.text = price
            imgView.setImageResource(img)

        }

    }
}