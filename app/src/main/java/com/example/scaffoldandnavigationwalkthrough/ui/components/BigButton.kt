package com.example.scaffoldandnavigationwalkthrough.ui.components

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

// A really visible button
@Composable
fun BigButton(text: String, onClick: () -> Unit) {
    Button(
        onClick = onClick
    ) {
        Text(text = text)
    }
}