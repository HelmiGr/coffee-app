package com.example.scaffoldandnavigationwalkthrough.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.scaffoldandnavigationwalkthrough.ui.screens.InfoScreen
import com.example.scaffoldandnavigationwalkthrough.ui.screens.MainScreen
import com.example.scaffoldandnavigationwalkthrough.ui.screens.SettingsScreen
import com.example.scaffoldandnavigationwalkthrough.viewmodels.CoffeeViewModel

@Composable
fun ScaffoldApp() {
    val navController = rememberNavController()
    // to get the current viewmodel instance:
    val coffeeViewModel: CoffeeViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
    val coffeeUiState = coffeeViewModel.coffeeUiState // to get the current ui state
    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable(route = "home") { MainScreen(navController, modifier = Modifier, uiState = coffeeUiState) }
        composable(route = "info") { InfoScreen(navController) }
        composable(route = "settings") { SettingsScreen(navController) }
    }
}