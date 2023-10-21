package com.example.foodorderapp.room

import androidx.room.Dao
import androidx.room.Query
import com.example.foodorderapp.data.model.Food

@Dao
interface FavoriteDao {
    @Query("SELECT * from favorite")
    suspend fun getFavorites() : List<Food>
}