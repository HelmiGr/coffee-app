package com.example.scaffoldandnavigationwalkthrough.ui.screens.recommendationScreen

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.example.scaffoldandnavigationwalkthrough.R
import com.example.scaffoldandnavigationwalkthrough.ui.appbars.BottomBar
import com.example.scaffoldandnavigationwalkthrough.ui.appbars.ScreenTopBar
import com.example.scaffoldandnavigationwalkthrough.viewmodels.CoffeeViewModel

// user can answer questions on what kind of a coffee they feel like trying today
// and the application will give a result based on the coffees retrieved from the api
// (or the current ones retrieved since they change all the time)
@Composable
fun RecommendationScreen(navController: NavController, viewModel: CoffeeViewModel) {
    Scaffold(
        topBar = { ScreenTopBar(stringResource(R.string.settings_screen_title), navController) },
        bottomBar = { BottomBar(navController) }
    ) { innerPadding ->
        CoffeeRecommendationQuiz(
            modifier = Modifier.padding(innerPadding),
            intensifiers = viewModel.uniqueIntensifiers,
            selectedIntensifier = viewModel.selectedIntensifier,
            onIntensifierSelected = { selected ->
                viewModel.selectedIntensifier = selected // updates state in ViewModel
            },
        ) { }
    }
}