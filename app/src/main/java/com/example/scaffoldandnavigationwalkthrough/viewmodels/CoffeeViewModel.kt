package com.example.scaffoldandnavigationwalkthrough.viewmodels

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.scaffoldandnavigationwalkthrough.models.Coffee
import com.example.scaffoldandnavigationwalkthrough.models.CoffeeApi
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

// if the ui is loading or an error occurred, show a spinner or error message
sealed interface CoffeeUiState {
    data class Success(val todos: List<Coffee>): CoffeeUiState
    object Error: CoffeeUiState
    object Loading: CoffeeUiState
}

class CoffeeViewModel: ViewModel() {
    var coffeeUiState: CoffeeUiState by mutableStateOf<CoffeeUiState>(CoffeeUiState.Loading)
        private set // means that only this viewmodel can modify the TodoUiState

    // once initialized call these functions:
    init {
        getCoffeeList()
    }

    private fun getCoffeeList() {
        viewModelScope.launch {
            var coffeeApi: CoffeeApi? = null
            try {
                coffeeApi = CoffeeApi.getInstance() // fetches the todos
                coffeeUiState = CoffeeUiState.Success(coffeeApi.getCoffees())
                Log.e("CoffeeViewModel", "In the success part of viewmodel")
            } catch (e: Exception) {
                Log.e("CoffeeViewModel", "Error fetching todos: ${e.message}")
                coffeeUiState = CoffeeUiState.Error
            }
        }
    }
}