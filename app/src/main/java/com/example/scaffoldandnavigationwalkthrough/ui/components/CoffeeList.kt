package com.example.scaffoldandnavigationwalkthrough.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.scaffoldandnavigationwalkthrough.models.Coffee

// column with individual todos listed
// components would be used if this was needed in multiple places
// made a component since it's used separately in the walkthrough and is used in a screen
@Composable
fun CoffeeList(modifier: Modifier = Modifier, coffees: List<Coffee>) {
    LazyColumn (
        modifier = modifier.padding(8.dp)
    ) {
        items(coffees) { coffee ->
            Text(
                text = coffee.blend_name,
                modifier = Modifier.padding(top = 4.dp, bottom = 4.dp)
            )
            HorizontalDivider(color = Color.LightGray, thickness = 2.dp)
        }
    }
}