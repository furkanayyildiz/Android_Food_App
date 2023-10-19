package com.example.foodorderapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.foodorderapp.data.model.Cart
import com.example.foodorderapp.databinding.CartCardViewBinding
import com.example.foodorderapp.ui.viewModel.CartViewModel

class CartAdapter(var mContext: Context, var cartList: List<Cart>, var viewModel: CartViewModel)
    : RecyclerView.Adapter<CartAdapter.CardViewHolder>() {

        inner class CardViewHolder(var view: CartCardViewBinding) : RecyclerView.ViewHolder(view.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val binding = CartCardViewBinding.inflate(LayoutInflater.from(mContext), parent, false)
        return CardViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return cartList.size
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
       val cartItem = cartList.get(position)
       val view = holder.view

       val url = "http://kasimadalan.pe.hu/yemekler/resimler/${cartItem.yemek_resim_adi}"
        Glide.with(mContext).load(url).into(view.imageViewCart)

        view.textViewCartProductName.text = cartItem.yemek_adi
        view.textViewCartProductQuantity.text = cartItem.yemek_siparis_adet
        view.textViewCartProductPrice.text = cartItem.yemek_fiyat

        val cq = cartItem.yemek_siparis_adet.toInt()
        val cp = cartItem.yemek_fiyat.toInt()
        val itemTotal = cp * cq
        val itemTotalText = itemTotal.toString()
        view.textViewCartProductTotal.text = "$itemTotalText TL"
    }
}