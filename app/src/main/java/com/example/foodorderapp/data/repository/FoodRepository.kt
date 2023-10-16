package com.example.foodorderapp.data.repository

import com.example.foodorderapp.data.datasource.FoodDataSource
import com.example.foodorderapp.data.model.Food


class FoodRepository(var foodDataSource: FoodDataSource) {
    suspend fun getFoods() : List<Food> = foodDataSource.getFoods()
}