package com.example.scaffoldandnavigationwalkthrough.ui.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.scaffoldandnavigationwalkthrough.R

@Composable
fun LoadingScreen() {
    Text(stringResource(R.string.loading_screen_content))
}