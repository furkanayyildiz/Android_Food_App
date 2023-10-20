package com.example.foodorderapp.ui.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.foodorderapp.data.model.Cart
import com.example.foodorderapp.data.model.Food
import com.example.foodorderapp.data.repository.FoodRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CartViewModel @Inject constructor(var foodRepository: FoodRepository) : ViewModel() {
    var cartList = MutableLiveData<List<Cart>>()

    init {
        getCart()
    }
    fun getCart(){
        CoroutineScope(Dispatchers.Main).launch {
            try {
                cartList.value = foodRepository.getCartItems()
                Log.e("cart view model", "${cartList.value}")
            }catch (e:Exception){

            }
        }
    }

    fun deleteCartItem (sepet_yemek_id : Int, kullanici_adi: String){
        CoroutineScope(Dispatchers.Main).launch {
            foodRepository.deleteCartItem(sepet_yemek_id, kullanici_adi)
            getCart()
        }
    }
}