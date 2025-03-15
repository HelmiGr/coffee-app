package com.example.scaffoldandnavigationwalkthrough.viewmodels

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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

    // --- main screen states ---
    // storing the coffees that have been fetched
    private var fetchedCoffees: List<Coffee> = emptyList()
    // stores all coffees even from earlier fetches
    var displayedCoffees by mutableStateOf<List<Coffee>>(emptyList())
        private set

    // --- recommendation screen states ---
    // stores unique intensifiers for the recommendation quiz
    var uniqueIntensifiers by mutableStateOf<List<String>>(emptyList())
        private set
    // keeps track of which button in the recommendations has been pressed
    var selectedIntensifier by mutableStateOf<String?>(null)
    // stores the recommended coffee
    var recommendedCoffee by mutableStateOf<Coffee?>(null)
        private set

    // once initialized call these functions:
    init {
        getCoffeeList()
    }

    fun getCoffeeList() {
        viewModelScope.launch { // performs the network call asynchronously
            var coffeeApi: CoffeeApi? = null
            try {
                coffeeApi = CoffeeApi.getInstance() // gets an instance of the CoffeeApi
                fetchedCoffees = coffeeApi.getCoffees() // fetches the coffees
                displayedCoffees = displayedCoffees + fetchedCoffees // if a fetch has been done more than once, store all coffees here
                uniqueIntensifiers = displayedCoffees.map { it.intensifier }.distinct() // store coffees with unique intensifiers here

                // if getting an instance is successful, a list of coffees is loaded with coffeeApi.getCoffees()
                coffeeUiState = CoffeeUiState.Success(displayedCoffees)

                // this line if for testing for whether uiState works and displays the error screen
                // comment out coffeeUiState = CoffeeUiState.Success... for this
                // throw Exception("Simulated network error")
            } catch (e: Exception) {
                Log.e("CoffeeViewModel", "Error fetching coffees: ${e.message}")
                coffeeUiState = CoffeeUiState.Error // updates the CoffeeUiState to error
            }

            // this works!
            // logCurrentState() // the current state, once it changes, gets logged correctly
        }
    }

    // find and update the recommended coffee
    fun recommendCoffee() {
        selectedIntensifier?.let { intensifier ->
            recommendedCoffee = displayedCoffees.firstOrNull { it.intensifier == intensifier }
        }
    }

    // for testing
    private fun logCurrentState() {
        // the current state of coffeeUiState
        when (coffeeUiState) {
            is CoffeeUiState.Loading -> Log.d("CoffeeViewModel", "Current state: Loading")
            is CoffeeUiState.Success -> Log.d("CoffeeViewModel", "Current state: Success")
            is CoffeeUiState.Error -> Log.d("CoffeeViewModel", "Current state: Error")
        }
    }
}