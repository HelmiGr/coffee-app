package com.example.scaffoldandnavigationwalkthrough.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.scaffoldandnavigationwalkthrough.models.Coffee

// A card that displays information about a specific coffee
@Composable
fun CoffeeCard(coffee: Coffee) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = coffee.blend_name,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            Text(text = "Description: ${coffee.notes}")
            Text(text = "Origin: ${coffee.origin}")
            Text(text = "Intensifier: ${coffee.intensifier}")
            Text(text = "Variety: ${coffee.variety}")
        }
    }
}