package com.example.foodorderapp.data.model

import java.io.Serializable

data class Cart(var sepet_yemek_id : String,
                var yemek_adi: String,
                var yemek_resim_adi: String,
                var yemek_fiyat: String,
                var yemek_siparis_adet: String,
                var kullanici_adi: String) : Serializable {
}