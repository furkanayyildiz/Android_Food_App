package com.example.foodorderapp.di

import com.example.foodorderapp.data.datasource.FoodDataSource
import com.example.foodorderapp.data.repository.FoodRepository
import com.example.foodorderapp.retrofit.ApiUtils
import com.example.foodorderapp.retrofit.FoodDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideFoodsRepository(foodDataSource: FoodDataSource) : FoodRepository {
        return FoodRepository(foodDataSource)
    }
    @Provides
    @Singleton
    fun provideFoodDataSource(foodDao: FoodDao) : FoodDataSource {
        return FoodDataSource(foodDao)
    }
    @Provides
    @Singleton
    fun provideFoodsDao() : FoodDao{
        return ApiUtils.getFoodsDao()
    }
}