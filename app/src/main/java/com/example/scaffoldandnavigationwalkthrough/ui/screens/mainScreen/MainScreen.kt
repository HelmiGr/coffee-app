package com.example.scaffoldandnavigationwalkthrough.ui.screens.mainScreen

import android.util.Log
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.example.scaffoldandnavigationwalkthrough.R
import com.example.scaffoldandnavigationwalkthrough.ui.appbars.BottomBar
import com.example.scaffoldandnavigationwalkthrough.ui.appbars.MainTopAppBar
import com.example.scaffoldandnavigationwalkthrough.ui.screens.ErrorScreen
import com.example.scaffoldandnavigationwalkthrough.ui.screens.LoadingScreen
import com.example.scaffoldandnavigationwalkthrough.viewmodels.CoffeeUiState
import com.example.scaffoldandnavigationwalkthrough.viewmodels.CoffeeViewModel

@Composable
fun MainScreen(navController: NavController, modifier: Modifier, uiState: CoffeeUiState, viewModel: CoffeeViewModel) {
    showCurrentState(uiState) // this also works displaying the proper state.
    // so the proper state is updated, but either Scaffold isn't updating it properly or
    // there might be a problem with loading the different screens

    Scaffold(
        topBar = { MainTopAppBar(stringResource(R.string.main_screen_title), navController) },
        bottomBar = { BottomBar(navController) }
    ) { innerPadding ->
        when (uiState) {
            is CoffeeUiState.Loading -> LoadingScreen()
            is CoffeeUiState.Success -> CoffeeList(modifier.padding(innerPadding), uiState.coffees) { viewModel.getCoffeeList() }
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