package com.example.foodorderapp.data.datasource

import android.util.Log
import com.example.foodorderapp.data.model.Cart
import com.example.foodorderapp.data.model.Food
import com.example.foodorderapp.retrofit.FoodDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class FoodDataSource(val foodDao: FoodDao) {
    suspend fun  getFoods() : List<Food> = withContext(Dispatchers.IO){
        return@withContext foodDao.getFoods().yemekler
    }
    suspend fun addToCart(yemek_adi: String,
                          yemek_resim_adi: String,
                          yemek_fiyat: Int,
                          yemek_siparis_adet: Int,
                          kullanici_adi: String){
        val response = foodDao.addToCart(yemek_adi,yemek_resim_adi,yemek_fiyat,yemek_siparis_adet,kullanici_adi)
        Log.e("Add", "Success: ${response.success} - Message: ${response.message}")
        val response2 = foodDao.getCartItems("furkan_ayyildiz")
        Log.e("cart", "Success: ${response2.sepet_yemekler} ")
    }
    suspend fun getCartItems() : List<Cart> = withContext(Dispatchers.IO){
        val response = foodDao.getCartItems("furkan_ayyildiz")
        Log.e("cart", "Success: ${response.success} ")
        return@withContext response.sepet_yemekler
    }

    /*
    suspend fun increaseQuantity(quantity : String,) : String = withContext(Dispatchers.IO){
        val number = quantity.toInt()
        val increasedNumber = number + 1

        return@withContext  increasedNumber.toString()
    }
    suspend fun decreaseQuantity(quantity : String) : String = withContext(Dispatchers.IO){
        val number = quantity.toInt()
        val decreasedNumber = number - 1

        return@withContext  decreasedNumber.toString()
    }
    */
}