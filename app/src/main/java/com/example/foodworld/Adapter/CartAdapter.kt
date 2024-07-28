package com.example.foodworld.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.foodworld.databinding.CartItemsBinding

class CartAdapter(private val Items: MutableList<String>,private val Price : MutableList<String>, private val Image : MutableList<Int>):RecyclerView.Adapter<CartAdapter.CartViewHolder>() {

    private val itemQuantities = IntArray(Items.size) { 1 }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        return CartViewHolder(
            CartItemsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
//        val item = Items[position]
//        val price = Price[position]
//        val img = Image[position]
//        val quantities = itemQuantities[position]
//        holder.bind(item,price,img,quantities)
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return Items.size
    }

    inner class CartViewHolder(private val binding: CartItemsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.apply {
                val quantites = itemQuantities[position]
                foodName.text = Items[position]
                foodPrice.text = Price[position]
                foodImg.setImageResource(Image[position])
                cartQuantities.text = quantites.toString()
                subBtn.setOnClickListener {
                    sub(position)
                }
                addBtn.setOnClickListener {
                    add(position)
                }
                deletBtn.setOnClickListener {
                    delet(position)
                }
            }
        }
//        fun bind(item: String, price: String, img: Int, quantities : Int) {
//            binding.foodName.text=item
//            binding.foodPrice.text=price
//            binding.foodImg.setImageResource(img)
//            binding.itemQuantities.text.toString()=quantities
//            binding.subBtn.setOnClickListener {
//
//            }
//            binding.addBtn.setOnClickListener {
//
//            }
//            binding.deletBtn.setOnClickListener {
//
//            }
//        }


      private  fun sub(position: Int) {
            if (itemQuantities[position] > 1) {
                itemQuantities[position]--
                binding.cartQuantities.text =itemQuantities[position].toString()
            }
        }
      private  fun add(position: Int) {
            if (itemQuantities[position] < 10) {
                itemQuantities[position]++
                binding.cartQuantities.text =itemQuantities[position].toString()
            }
        }
      private  fun delet(position: Int){
            Items.removeAt(position)
            Price.removeAt(position)
            Image.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position,Items.size)
        }
    }
}