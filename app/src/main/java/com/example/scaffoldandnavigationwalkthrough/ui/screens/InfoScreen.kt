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
import com.example.scaffoldandnavigationwalkthrough.ui.appbars.ScreenTopBar
import com.example.scaffoldandnavigationwalkthrough.ui.components.CoffeeList

// general information about coffee
@Composable
fun InfoScreen(navController: NavController) {
    Scaffold(
        topBar = { ScreenTopBar(stringResource(R.string.info_screen_title), navController) },
        bottomBar = { BottomBar(navController) }
    ) { innerPadding ->
        Text(text= stringResource(R.string.info_screen_content), modifier = Modifier.padding(innerPadding))
    }
}