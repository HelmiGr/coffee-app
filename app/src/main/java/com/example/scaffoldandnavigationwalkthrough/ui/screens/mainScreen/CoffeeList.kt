package com.example.scaffoldandnavigationwalkthrough.ui.screens.mainScreen

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.scaffoldandnavigationwalkthrough.models.Coffee
import com.example.scaffoldandnavigationwalkthrough.ui.components.BigButton
import com.example.scaffoldandnavigationwalkthrough.ui.components.CoffeeCard

// list of individual coffees with a button at the end to do something
@Composable
fun CoffeeList(modifier: Modifier = Modifier, coffees: List<Coffee>, onShowMore: () -> Unit) {
    LazyColumn (
        modifier = modifier
    ) {
        item {
            Text(
                text = "Good Coffee Choices for the Day",
                modifier = Modifier.fillMaxWidth().padding(vertical = 12.dp),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
        }
        items(coffees) { coffee ->
            CoffeeCard(coffee)
        }
        item {
            BigButton(onClick = onShowMore)
        }
    }
}