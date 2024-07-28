package com.example.foodworld.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodworld.Adapter.PopularAdapter
import com.example.foodworld.R
import com.example.foodworld.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {
private lateinit var binding: FragmentSearchBinding
 private lateinit var adapter : PopularAdapter
private val searchFoodName = listOf("Burger","sandwich","mom","item")
    private val searchFoodPrice =listOf("₹100","₹500","₹200","₹50")
    private val searchFoodImg = listOf(
        R.drawable.menu1,
        R.drawable.menu2,
        R.drawable.menu3,
        R.drawable.menu4,
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    private val filterFoodName = mutableListOf<String>()
    private val filterFoodPrice = mutableListOf<String>()
    private val filterFoodImg = mutableListOf<Int>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSearchBinding.inflate(inflater,container,false)
        adapter = PopularAdapter(filterFoodName,filterFoodImg,filterFoodPrice)
        binding.searchRv.layoutManager = LinearLayoutManager(requireContext())
        binding.searchRv.adapter = adapter
        setupSearchView()
        showAllMenuItems()
        return binding.root
    }

    private fun showAllMenuItems() {
        filterFoodName.clear()
        filterFoodPrice.clear()
        filterFoodImg.clear()

        filterFoodName.addAll(searchFoodName)
        filterFoodPrice.addAll(searchFoodPrice)
        filterFoodImg.addAll(searchFoodImg)
        adapter.notifyDataSetChanged()
    }

    private fun setupSearchView() {
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String): Boolean {
                filterMenuItems(query)
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                filterMenuItems(newText)
                return true
            }

        })
    }

    private fun filterMenuItems(query: String) {
        filterFoodName.clear()
        filterFoodPrice.clear()
        filterFoodImg.clear()

        searchFoodName.forEachIndexed { index, foodName ->
            if (foodName.contains(query, ignoreCase = true)){
                filterFoodName.add(foodName)
                filterFoodPrice.add(searchFoodPrice[index])
                filterFoodImg.add(searchFoodImg[index])
            }
        }
        adapter.notifyDataSetChanged()
    }

    companion object {

    }
}