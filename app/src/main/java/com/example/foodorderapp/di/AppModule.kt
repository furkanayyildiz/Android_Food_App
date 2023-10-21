package com.example.foodorderapp.di

import android.content.Context
import androidx.room.Room
import com.example.foodorderapp.data.datasource.FoodDataSource
import com.example.foodorderapp.data.repository.FoodRepository
import com.example.foodorderapp.retrofit.ApiUtils
import com.example.foodorderapp.retrofit.FoodDao
import com.example.foodorderapp.room.Database
import com.example.foodorderapp.room.FavoriteDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
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
    fun provideFoodDataSource(foodDao: FoodDao, favoriteDao: FavoriteDao) : FoodDataSource {
        return FoodDataSource(foodDao, favoriteDao)
    }
    @Provides
    @Singleton
    fun provideFoodsDao() : FoodDao{
        return ApiUtils.getFoodsDao()
    }

    @Provides
    @Singleton
    fun provideFavoriteDao(@ApplicationContext context: Context) : FavoriteDao{
        val db = Room.databaseBuilder(context, Database::class.java, "favorite.sqlite")
            .createFromAsset("favorite.sqlite").build()
        return db.getFavoriteDao()
    }
}