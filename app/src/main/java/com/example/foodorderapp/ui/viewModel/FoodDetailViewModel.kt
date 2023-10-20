package com.example.foodorderapp.ui.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.foodorderapp.data.repository.FoodRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FoodDetailViewModel @Inject constructor(var foodRepository: FoodRepository) : ViewModel() {
    var booleanData = MutableLiveData<Boolean>()
    fun addToCart(yemek_adi: String,
                  yemek_resim_adi: String,
                  yemek_fiyat: Int,
                  yemek_siparis_adet: Int,
                  kullanici_adi: String){
        CoroutineScope(Dispatchers.Main).launch {
            try {
                booleanData.value =  foodRepository.addToCart(yemek_adi, yemek_resim_adi, yemek_fiyat, yemek_siparis_adet, kullanici_adi)
            }catch (e: Exception){
                Log.e("Add to cart", "$e")
            }

        }

    }

}