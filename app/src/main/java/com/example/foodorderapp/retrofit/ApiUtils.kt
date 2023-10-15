package com.example.foodorderapp.retrofit

class ApiUtils {
    companion object {
        val BASE_URL = "http://kasimadalan.pe.hu/yemekler"
        fun getFoodsDao() : FoodDao {
            return RetrofitClient.getClient(BASE_URL).create(FoodDao::class.java)
        }
    }
}