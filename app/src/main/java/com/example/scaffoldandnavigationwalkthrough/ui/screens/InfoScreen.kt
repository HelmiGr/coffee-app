package com.example.scaffoldandnavigationwalkthrough.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.scaffoldandnavigationwalkthrough.R
import com.example.scaffoldandnavigationwalkthrough.ui.appbars.BottomBar
import com.example.scaffoldandnavigationwalkthrough.ui.appbars.ScreenTopBar
import com.example.scaffoldandnavigationwalkthrough.ui.components.CenteredText

// general information about coffee
@Composable
fun InfoScreen(navController: NavController) {
    Scaffold(
        topBar = { ScreenTopBar(stringResource(R.string.info_screen_title), navController) },
        bottomBar = { BottomBar(navController) }
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding).padding(16.dp)
        ) {
            CenteredText(
                text = stringResource(R.string.info_screen_title_content),
                modifier = Modifier.fillMaxWidth().padding(vertical = 12.dp)
            )
            CenteredText(
                text = stringResource(R.string.info_screen_text_content),
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}