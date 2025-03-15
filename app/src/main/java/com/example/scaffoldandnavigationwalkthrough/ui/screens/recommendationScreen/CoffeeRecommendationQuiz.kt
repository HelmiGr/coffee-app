package com.example.scaffoldandnavigationwalkthrough.ui.screens.recommendationScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.scaffoldandnavigationwalkthrough.models.Coffee
import com.example.scaffoldandnavigationwalkthrough.ui.components.BigButton
import com.example.scaffoldandnavigationwalkthrough.ui.components.CoffeeCard

// get the coffees and take the intensifier of each one
// if the same intensifier is twice in one of the coffees, then only show it once
@Composable
fun CoffeeRecommendationQuiz(modifier: Modifier, intensifiers: List<String>, selectedIntensifier: String?, onIntensifierSelected: (String) -> Unit, recommendedCoffee: Coffee?, onSubmit: () -> Unit) {
    LazyColumn(
        modifier = modifier
    ) {
        item {
            Text("Get a coffee recommendation based on the coffees in our today's recommended list based on the intensifier")
        }
        items(intensifiers) { intensifier ->
            DifferentRadioButton(
                intensifier = intensifier,
                selected = ( selectedIntensifier == intensifier ),
                onSelected = { onIntensifierSelected(intensifier) }
            )
        }
        item {
            BigButton("Submit", onClick = onSubmit)
        }
        if (recommendedCoffee != null) {
            item {
                Column {
                    Text("The recommended coffee is:")
                    CoffeeCard(recommendedCoffee)
                }
            }
        }
    }
}