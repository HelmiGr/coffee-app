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
// if everything has loaded successfully, show a list of Coffees
sealed interface CoffeeUiState {
    data class Success(val coffees: List<Coffee>): CoffeeUiState
    object Error: CoffeeUiState
    object Loading: CoffeeUiState
}

class CoffeeViewModel: ViewModel() {
    var coffeeUiState: CoffeeUiState by mutableStateOf(CoffeeUiState.Loading)
        private set // means that only this viewmodel can modify the TodoUiState

    // once initialized call these functions:
    init {
        getCoffeeList()
    }

    private fun getCoffeeList() {
        viewModelScope.launch { // performs the network call asynchronously
            var coffeeApi: CoffeeApi? = null
            try {
                coffeeApi = CoffeeApi.getInstance() // gets an instance of the CoffeeApi
                // if getting an instance is successful, a list of coffees is loaded with coffeeApi.getCoffees()
                coffeeUiState = CoffeeUiState.Success(coffeeApi.getCoffees())
            } catch (e: Exception) {
                Log.e("CoffeeViewModel", "Error fetching coffees: ${e.message}")
                coffeeUiState = CoffeeUiState.Error // updates the CoffeeUiState to error
            }
        }
    }
}