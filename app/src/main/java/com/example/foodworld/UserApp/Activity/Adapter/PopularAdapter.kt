package com.example.foodworld.UserApp.Activity.Adapter

import android.content.Context
import android.content.DialogInterface.OnClickListener
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.denzcoskun.imageslider.interfaces.ItemClickListener
import com.example.foodworld.UserApp.Activity.MenuDeatial
import com.example.foodworld.databinding.MenuItemsBinding

class PopularAdapter(private val Items : MutableList<String> , private  val  Image:MutableList<Int>, private val Price : MutableList<String>,private val requireContext: Context) : RecyclerView.Adapter<PopularAdapter.PopularViewHolder>() {

private val ItemClickListener : OnClickListener ?= null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularViewHolder {
        return PopularViewHolder(MenuItemsBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: PopularViewHolder, position: Int) {
//        val item = Items[position]
//        val img = Image[position]
//        val price = Price[position]
        holder.bind(position)
    }
    override fun getItemCount(): Int {
      return Items.size
    }
 inner class PopularViewHolder(private val binding:MenuItemsBinding) : RecyclerView.ViewHolder(binding.root) {
     init {
         binding.root.setOnClickListener{
             val position = adapterPosition
             if (position != RecyclerView.NO_POSITION){
                 ItemClickListener?.onItemClick(position)
             }
             val intent = Intent(requireContext,MenuDeatial::class.java)
             intent.putExtra("ItemName",Items.get(position))
             intent.putExtra("ItemPrice",Price.get(position))
             intent.putExtra("ItemImg",Image.get(position))
             requireContext.startActivity(intent)
         }
     }
        fun bind(position: Int) {
            binding.apply {
                foodName.text = Items[position]
                foodPrice.text=Price[position]
                foodImg.setImageResource(Image[position])


            }
        }

//        private val imgView = binding.foodImg
//        fun bind(item: String, img: Int, price: String) {
//            binding.foodName.text = item
//            binding.foodPrice.text = price
//            imgView.setImageResource(img)
//
//        }

    }
    interface  OnClickListener{fun onItemClick(position: Int)

    }
}


