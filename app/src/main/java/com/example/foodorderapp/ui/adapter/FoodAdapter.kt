package com.example.foodorderapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.foodorderapp.R
import com.example.foodorderapp.data.model.Food
import com.example.foodorderapp.databinding.FoodCardViewBinding
import com.example.foodorderapp.ui.fragment.HomeFragmentDirections
import com.example.foodorderapp.ui.viewModel.HomeViewModel
import com.google.android.material.snackbar.Snackbar

class FoodAdapter (var mContext: Context, var foodList:List<Food>, var viewModel: HomeViewModel)
    : RecyclerView.Adapter<FoodAdapter.CardViewHolder>() {

    inner class CardViewHolder(var view: FoodCardViewBinding) : RecyclerView.ViewHolder(view.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val binding = FoodCardViewBinding.inflate(LayoutInflater.from(mContext), parent, false)
        return  CardViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return foodList.size
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val food = foodList.get(position)
        val view = holder.view

        view.textViewName.text = food.yemek_adi
        view.textViewPrice.text = "${food.yemek_fiyat} ₺"

        val url = "http://kasimadalan.pe.hu/yemekler/resimler/${food.yemek_resim_adi}"
        Glide.with(mContext).load(url).override(500, 500).into(view.imageViewFood)

        view.cardView.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeToDetail(food = food)
            Navigation.findNavController(it).navigate(action)
        }
        //view.checkBoxFavorite.isChecked = true
        view.checkBoxFavorite.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked){

                view.checkBoxFavorite.buttonDrawable =  ContextCompat.getDrawable(mContext, R.drawable.favorite_icon_fill)
                Snackbar.make(view.checkBoxFavorite,"Favorilere eklendi", Snackbar.LENGTH_SHORT).show()
            }else{
                view.checkBoxFavorite.buttonDrawable =  ContextCompat.getDrawable(mContext, R.drawable.favorite_icon_outline)
                Snackbar.make(view.checkBoxFavorite,"Favorilerden silindi", Snackbar.LENGTH_SHORT).show()
            }
        }

    }
}


