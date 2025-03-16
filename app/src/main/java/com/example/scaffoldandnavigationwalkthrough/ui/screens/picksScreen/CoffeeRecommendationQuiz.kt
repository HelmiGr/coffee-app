package com.example.scaffoldandnavigationwalkthrough.ui.screens.picksScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.scaffoldandnavigationwalkthrough.R
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
            Text(stringResource(R.string.picks_screen_title_content))
        }
        items(intensifiers) { intensifier ->
            DifferentRadioButton(
                intensifier = intensifier,
                selected = ( selectedIntensifier == intensifier ),
                onSelected = { onIntensifierSelected(intensifier) }
            )
        }
        item {
            BigButton(stringResource(R.string.picks_screen_button_text), onClick = onSubmit)
        }
        if (recommendedCoffee != null) {
            item {
                Column {
                    Text(stringResource(R.string.picks_screen_recommendation_quiz_result_text))
                    CoffeeCard(recommendedCoffee)
                }
            }
        }
    }
}