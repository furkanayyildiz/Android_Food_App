package com.example.foodorderapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodorderapp.R
import com.example.foodorderapp.databinding.FragmentCartBinding
import com.example.foodorderapp.ui.adapter.CartAdapter
import com.example.foodorderapp.ui.viewModel.CartViewModel
import com.example.foodorderapp.ui.viewModel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CartFragment : Fragment() {
    private lateinit var binding: FragmentCartBinding
    private lateinit var viewModel: CartViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCartBinding.inflate(inflater, container, false)

        binding.cartRecyclerView.layoutManager = LinearLayoutManager(requireContext())

        viewModel.cartList.observe(viewLifecycleOwner){
            Log.e("cart fragment", "${it}")
            val cartAdapter = CartAdapter(requireContext(),it,viewModel)
            binding.cartRecyclerView.adapter = cartAdapter
        }
        return binding.root
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: CartViewModel by viewModels()
        viewModel = tempViewModel
    }

}