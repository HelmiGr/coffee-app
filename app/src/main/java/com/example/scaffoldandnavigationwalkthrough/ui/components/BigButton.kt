package com.example.scaffoldandnavigationwalkthrough.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

// A really visible button
@Composable
fun BigButton(text: String, onClick: () -> Unit, modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Button(
            onClick = onClick,
            modifier = modifier
        ) {
            Text(text = text)
        }
    }
}