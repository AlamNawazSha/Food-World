package com.example.foodworld.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.interfaces.ItemClickListener
import com.denzcoskun.imageslider.models.SlideModel
import com.example.foodworld.Adapter.PopularAdapter
import com.example.foodworld.R
import com.example.foodworld.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
 lateinit var binding: FragmentHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater,container,false)

        val imagelist = ArrayList<SlideModel>()
        imagelist.add(SlideModel(R.drawable.banner1, ScaleTypes.FIT))
        imagelist.add(SlideModel(R.drawable.banner2, ScaleTypes.FIT))
        imagelist.add(SlideModel(R.drawable.banner3, ScaleTypes.FIT))

        val imgSlider = binding.imageSlider
        imgSlider.setImageList(imagelist)
        imgSlider.setImageList(imagelist,ScaleTypes.FIT)
        imgSlider.setItemClickListener(object : ItemClickListener{
            override fun doubleClick(position: Int) {}
            override fun onItemSelected(position: Int) {
                val itemPosition = imagelist[position]
                val itemMessage = "Selected Image $position"
                Toast.makeText(requireContext(),itemMessage,Toast.LENGTH_LONG).show()
            }
        })

        val item = listOf("Burger","sandwich","mom","item")
        val price = listOf("₹100","₹500","₹200","₹50")
        val img = listOf(
            R.drawable.menu1,
            R.drawable.menu2,
            R.drawable.menu3,
            R.drawable.menu4,
        )
        val adapter = PopularAdapter(ArrayList(item),ArrayList(img),ArrayList(price))
        binding.menuRv.layoutManager = LinearLayoutManager(requireContext())
        binding.menuRv.adapter = adapter
        binding.viewAllMenu.setOnClickListener {
            val bottomSheetDialog = MenuBottomSheetFragment()
            bottomSheetDialog.show(parentFragmentManager,"test")
        }
        return binding.root
    }

    companion object {

    }
}