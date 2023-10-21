package com.example.foodorderapp.data.datasource

import android.util.Log
import com.example.foodorderapp.R
import com.example.foodorderapp.data.model.Cart
import com.example.foodorderapp.data.model.Food
import com.example.foodorderapp.retrofit.FoodDao
import com.example.foodorderapp.room.FavoriteDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class FoodDataSource(val foodDao: FoodDao, val favoriteDao: FavoriteDao) {
    suspend fun  getFoods() : List<Food> = withContext(Dispatchers.IO){
        return@withContext foodDao.getFoods().yemekler
    }
    suspend fun addToCart(yemek_adi: String,
                          yemek_resim_adi: String,
                          yemek_fiyat: Int,
                          yemek_siparis_adet: Int,
                          kullanici_adi: String) {

        foodDao.addToCart(yemek_adi,yemek_resim_adi,yemek_fiyat,yemek_siparis_adet,kullanici_adi)


    }
    suspend fun getCartItems() : List<Cart> = withContext(Dispatchers.IO){
        val response = foodDao.getCartItems("furkan_ayyildiz")
        Log.e("cart data source - cart ", "Success: ${response.success} ")
        return@withContext response.sepet_yemekler
    }

    suspend fun deleteCartItem(sepet_yemek_id : Int, kullanici_adi: String){
        val response = foodDao.deleteCartItem(sepet_yemek_id,kullanici_adi)
        Log.e("cart delete", "Success: ${response.success} - Message ${response.message}")
    }

}