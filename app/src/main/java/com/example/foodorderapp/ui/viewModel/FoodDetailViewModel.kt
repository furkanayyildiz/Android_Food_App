package com.example.foodorderapp.ui.viewModel

import androidx.lifecycle.ViewModel
import com.example.foodorderapp.data.repository.FoodRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FoodDetailViewModel @Inject constructor(var foodRepository: FoodRepository) : ViewModel() {

}