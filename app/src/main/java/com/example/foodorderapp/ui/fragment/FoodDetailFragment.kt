package com.example.foodorderapp.ui.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.foodorderapp.R
import com.example.foodorderapp.databinding.FoodCardViewBinding
import com.example.foodorderapp.databinding.FragmentFoodDetailBinding
import com.example.foodorderapp.ui.viewModel.CartViewModel
import com.example.foodorderapp.ui.viewModel.FoodDetailViewModel
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FoodDetailFragment : Fragment() {
    private lateinit var binding: FragmentFoodDetailBinding
    private lateinit var viewModel: FoodDetailViewModel
    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =  FragmentFoodDetailBinding.inflate(inflater, container, false)
        val bundle: FoodDetailFragmentArgs by navArgs()

        val food = bundle.food

        binding.textViewDetailName.text = food.yemek_adi

        val url = "http://kasimadalan.pe.hu/yemekler/resimler/${food.yemek_resim_adi}"
        Glide.with(this).load(url).into(binding.imageViewDetailImage)

        binding.textViewDetailPageQuantity.text = "1"
        binding.textViewDetailPagePrice.text = "${food.yemek_fiyat} TL"
        binding.textViewDetailPageTotal.text = "${food.yemek_fiyat} TL"

        binding.imageButtonDetailPageAdd.setOnClickListener {
            val quantity = binding.textViewDetailPageQuantity.text.toString()
            var newQuantity = quantity.toInt()
            var increasedQuantity = newQuantity + 1

            val price  = food.yemek_fiyat
            var newTotal = price.toInt()
            var increasedTotal = newTotal * increasedQuantity

            binding.textViewDetailPageQuantity.text = increasedQuantity.toString()
            binding.textViewDetailPageTotal.text = "${increasedTotal.toString()} TL"
        }

        binding.imageButtonDetailPageRemove.setOnClickListener {
            val quantity = binding.textViewDetailPageQuantity.text.toString()
            var newQuantity = quantity.toInt()
            if(newQuantity ==1) {
                Snackbar.make(it,"Quantity cannot be less than 1", Snackbar.LENGTH_SHORT).show()
            }else {
                var increasedQuantity = newQuantity - 1

                var total = binding.textViewDetailPageTotal.text
                var splitedTotal = total.split(" ").first()
                var splitedTotalConverted = splitedTotal.toInt()
                val price  = food.yemek_fiyat
                var priceConverted = price.toInt()
                var decreasedTotal = splitedTotalConverted - priceConverted

                binding.textViewDetailPageQuantity.text = increasedQuantity.toString()
                binding.textViewDetailPageTotal.text = "${decreasedTotal.toString()} TL"
            }

        }
        binding.buttonDetailPageAddToCart.setOnClickListener {
            val quantity = binding.textViewDetailPageQuantity.text.toString()
            var newQuantity = quantity.toInt()
            val yemek_fiyat_sayi= food.yemek_fiyat.toInt()

            val yemek_adi = food.yemek_adi
            val yemek_resim_adi = food.yemek_resim_adi
            val yemek_fiyat = yemek_fiyat_sayi
            val yemek_siparis_adet = newQuantity
            val kullanici_adi = "furkan_ayyildiz"
            Log.e("parametre","$yemek_adi - $yemek_resim_adi - $yemek_fiyat - $yemek_siparis_adet - $kullanici_adi")
            viewModel.addToCart(yemek_adi,yemek_resim_adi,yemek_fiyat,yemek_siparis_adet,kullanici_adi)

            Snackbar.make(it,"Product added to your cart", Snackbar.LENGTH_SHORT).show()

            val action = FoodDetailFragmentDirections.actionDetailToHome()
            Navigation.findNavController(it).navigate(action)

        }

        return  binding.root
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel:FoodDetailViewModel by viewModels()
        viewModel = tempViewModel
    }


}