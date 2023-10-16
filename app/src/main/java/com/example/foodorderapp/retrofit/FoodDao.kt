package com.example.foodorderapp.retrofit

import com.example.foodorderapp.data.model.FoodResponse
import retrofit2.http.GET

interface FoodDao {

    @GET("yemekler/tumYemekleriGetir.php")
    suspend fun getFoods() : FoodResponse
}