package com.example.foodorderapp.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.foodorderapp.data.model.Food

@Database(entities = [Food::class], version = 1)
abstract  class Database : RoomDatabase() {
    abstract fun getFavoriteDao() : FavoriteDao
}