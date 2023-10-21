package com.example.foodorderapp.ui.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.foodorderapp.data.model.Cart
import com.example.foodorderapp.data.repository.FoodRepository
import com.example.foodorderapp.databinding.FragmentFoodDetailBinding
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FoodDetailViewModel @Inject constructor(var foodRepository: FoodRepository) : ViewModel() {
    var cartList = MutableLiveData<List<Cart>>()
    private val _showSnackbarEvent = MutableLiveData<String>()
    val showSnackbarEvent: LiveData<String> get() = _showSnackbarEvent
    fun addToCart(yemek_adi: String,
                  yemek_resim_adi: String,
                  yemek_fiyat: Int,
                  yemek_siparis_adet: Int,
                  kullanici_adi: String) {
        CoroutineScope(Dispatchers.Main).launch {
            try {

                cartList.value =  foodRepository.getCartItems()
               val bol : Boolean =  cartList.value!!.any {
                    it.yemek_adi == yemek_adi
                }
                if(bol == true){
                    // ekleme yok
                    _showSnackbarEvent.value = "This product is in your cart"


                }else {
                    // ekleme var
                    foodRepository.addToCart(yemek_adi,yemek_resim_adi,yemek_fiyat,yemek_siparis_adet,kullanici_adi)
                    _showSnackbarEvent.value = "Product added to your cart"


                }
            }catch (e: Exception){
                Log.e("Add to cart", "$e")
            }

        }

    }

}