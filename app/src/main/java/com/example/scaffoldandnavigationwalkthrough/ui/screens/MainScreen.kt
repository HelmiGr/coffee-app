package com.example.scaffoldandnavigationwalkthrough.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.example.scaffoldandnavigationwalkthrough.R
import com.example.scaffoldandnavigationwalkthrough.ui.appbars.BottomBar
import com.example.scaffoldandnavigationwalkthrough.ui.appbars.MainTopAppBar
import com.example.scaffoldandnavigationwalkthrough.ui.components.CoffeeList
import com.example.scaffoldandnavigationwalkthrough.viewmodels.CoffeeUiState

@Composable
fun MainScreen(navController: NavController, modifier: Modifier, uiState: CoffeeUiState) {
    Scaffold(
        topBar = { MainTopAppBar(stringResource(R.string.main_screen_title), navController) },
        bottomBar = { BottomBar(navController) }
    ) { innerPadding ->
        when (uiState) {
            is CoffeeUiState.Loading -> LoadingScreen()
            is CoffeeUiState.Success -> CoffeeList(modifier.padding(innerPadding), uiState.coffees)
            is CoffeeUiState.Error -> ErrorScreen()
        }
    }
}