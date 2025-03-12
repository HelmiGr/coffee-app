package com.example.scaffoldandnavigationwalkthrough.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.scaffoldandnavigationwalkthrough.R
import com.example.scaffoldandnavigationwalkthrough.ui.appbars.BottomBar
import com.example.scaffoldandnavigationwalkthrough.ui.appbars.MainTopAppBar
import com.example.scaffoldandnavigationwalkthrough.ui.components.CoffeeList
import com.example.scaffoldandnavigationwalkthrough.viewmodels.CoffeeUiState
import com.example.scaffoldandnavigationwalkthrough.viewmodels.CoffeeViewModel

@Composable
fun MainScreen(navController: NavController, modifier: Modifier, uiState: CoffeeUiState) {
    val coffeeViewModel: CoffeeViewModel = viewModel()
    val newUiState = coffeeViewModel.coffeeUiState

    showCurrentState(newUiState) // this also works displaying the proper state.
    // so the proper state is updated, but either Scaffold isn't updating it properly or
    // there might be a problem with loading the different screens

    Scaffold(
        topBar = { MainTopAppBar(stringResource(R.string.main_screen_title), navController) },
        bottomBar = { BottomBar(navController) }
    ) { innerPadding ->
        when (newUiState) {
            is CoffeeUiState.Loading -> LoadingScreen()
            is CoffeeUiState.Success -> CoffeeList(modifier.padding(innerPadding), newUiState.coffees)
            is CoffeeUiState.Error -> ErrorScreen()
        }
    }
}

// for testing
private fun showCurrentState(newUiState: CoffeeUiState) {
    // the current state of coffeeUiState
    when (newUiState) {
        is CoffeeUiState.Loading -> Log.d("CoffeeViewModel", "Current state: Loading")
        is CoffeeUiState.Success -> Log.d("CoffeeViewModel", "Current state: Success")
        is CoffeeUiState.Error -> Log.d("CoffeeViewModel", "Current state: Error")
    }
}