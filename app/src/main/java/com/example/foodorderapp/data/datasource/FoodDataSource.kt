package com.example.foodorderapp.data.datasource

import com.example.foodorderapp.data.model.Food
import com.example.foodorderapp.retrofit.FoodDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class FoodDataSource(val foodDao: FoodDao) {
    suspend fun  getFoods() : List<Food> = withContext(Dispatchers.IO){
        return@withContext foodDao.getFoods().yemekler
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