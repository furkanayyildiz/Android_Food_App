package com.example.foodorderapp.data.repository

import com.example.foodorderapp.data.datasource.FoodDataSource
import com.example.foodorderapp.data.model.Cart
import com.example.foodorderapp.data.model.Food


class FoodRepository(var foodDataSource: FoodDataSource) {
    suspend fun getFoods() : List<Food> = foodDataSource.getFoods()

    suspend fun addToCart(yemek_adi: String,
                          yemek_resim_adi: String,
                          yemek_fiyat: Int,
                          yemek_siparis_adet: Int,
                          kullanici_adi: String) : Boolean = foodDataSource.addToCart(yemek_adi, yemek_resim_adi, yemek_fiyat, yemek_siparis_adet, kullanici_adi)

    suspend fun getCartItems() : List<Cart> = foodDataSource.getCartItems()

    suspend fun deleteCartItem (sepet_yemek_id : Int, kullanici_adi: String) = foodDataSource.deleteCartItem(sepet_yemek_id,kullanici_adi)

    /*
    suspend fun increaseQuantity(quantity : String) : String = foodDataSource.increaseQuantity(quantity)

    suspend fun decreaseQuantity(quantity : String) : String = foodDataSource.decreaseQuantity(quantity)*/


}