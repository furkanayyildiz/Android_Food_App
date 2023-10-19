package com.example.foodorderapp.retrofit

import com.example.foodorderapp.data.model.CRUDResponse
import com.example.foodorderapp.data.model.CartResponse
import com.example.foodorderapp.data.model.FoodResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface FoodDao {

    @GET("yemekler/tumYemekleriGetir.php")
    suspend fun getFoods() : FoodResponse

    @POST("yemekler/sepeteYemekEkle.php")
    @FormUrlEncoded
    suspend fun addToCart(@Field("yemek_adi") yemek_adi : String,
                          @Field("yemek_resim_adi") yemek_resim_adi : String,
                          @Field("yemek_fiyat") yemek_fiyat : Int,
                          @Field("yemek_siparis_adet") yemek_siparis_adet: Int,
                          @Field("kullanici_adi") kullanici_adi: String) : CRUDResponse
    @POST("yemekler/sepettekiYemekleriGetir.php")
    @FormUrlEncoded
    suspend fun getCartItems(@Field("kullanici_adi") kullanici_adi: String): CartResponse
}