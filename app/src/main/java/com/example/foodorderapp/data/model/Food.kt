package com.example.foodorderapp.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull
import java.io.Serializable

@Entity(tableName = "favorite")
data class Food(@PrimaryKey(autoGenerate = false)
                @ColumnInfo(name = "yemek_id") @NotNull var yemek_id : String ,
                @ColumnInfo(name = "yemek_adi") @NotNull var yemek_adi : String ,
                @ColumnInfo(name = "yemek_resim_adi") @NotNull var yemek_resim_adi : String,
                @ColumnInfo(name = "yemek_fiyat") @NotNull var yemek_fiyat : String) : Serializable {
}