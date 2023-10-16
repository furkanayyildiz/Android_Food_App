package com.example.foodorderapp.data.datasource

import com.example.foodorderapp.data.model.Food
import com.example.foodorderapp.retrofit.FoodDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class FoodDataSource(val foodDao: FoodDao) {
    suspend fun  getFoods() : List<Food> = withContext(Dispatchers.IO){
        return@withContext foodDao.getFoods().yemekler
    }
}