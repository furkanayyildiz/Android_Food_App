package com.example.foodorderapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.foodorderapp.R
import com.example.foodorderapp.data.model.Food
import com.example.foodorderapp.databinding.FragmentHomeBinding
import com.example.foodorderapp.ui.adapter.FoodAdapter
import com.example.foodorderapp.ui.viewModel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var viewModel: HomeViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =  FragmentHomeBinding.inflate(inflater, container, false)

        binding.recyclerViewFoods.layoutManager = GridLayoutManager(requireContext(),2)

        binding.searchView.setOnQueryTextListener(object : android.widget.SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {

                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                val foodList = viewModel.foodList.value
                val filteredFood = foodList?.filter { food: Food ->
                food.yemek_adi.contains(newText,ignoreCase = true)

                }
                if(newText == ""){
                    viewModel.getFoods()
                }
                viewModel.foodList.value = filteredFood
                return true
            }

        })

        viewModel.foodList.observe(viewLifecycleOwner){
            val foodAdapter = FoodAdapter(requireContext(), it ,viewModel)
            binding.recyclerViewFoods.adapter = foodAdapter
        }
        return binding.root
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: HomeViewModel by viewModels()
        viewModel = tempViewModel
    }

}