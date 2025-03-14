package com.example.scaffoldandnavigationwalkthrough.ui.components

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

// A really visible button
@Composable
fun BigButton(onClick: () -> Unit) {
    Button(
        onClick = onClick /* viewmodel.getcoffees */
    ) {
        Text(text = "Show More")
    }
}