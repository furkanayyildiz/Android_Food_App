package com.example.foodorderapp.ui.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.foodorderapp.data.model.Food
import com.example.foodorderapp.data.repository.FoodRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel  @Inject constructor(var foodRepository: FoodRepository) : ViewModel(){
    var foodList = MutableLiveData<List<Food>>()

    init {
        getFoods()
    }

    fun getFoods() {
        CoroutineScope(Dispatchers.Main).launch {
            try {
                foodList.value = foodRepository.getFoods()
            }catch (e:Exception){

        }
        }
    }
}