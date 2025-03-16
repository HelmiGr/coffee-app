package com.example.scaffoldandnavigationwalkthrough.ui.screens.picksScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.scaffoldandnavigationwalkthrough.R
import com.example.scaffoldandnavigationwalkthrough.models.Coffee
import com.example.scaffoldandnavigationwalkthrough.ui.components.BigButton
import com.example.scaffoldandnavigationwalkthrough.ui.components.CenteredText
import com.example.scaffoldandnavigationwalkthrough.ui.components.CoffeeCard

// get the coffees and take the intensifier of each one
// if the same intensifier is twice in one of the coffees, then only show it once
@Composable
fun CoffeeRecommendationQuiz(modifier: Modifier, intensifiers: List<String>, selectedIntensifier: String?, onIntensifierSelected: (String) -> Unit, recommendedCoffee: Coffee?, onSubmit: () -> Unit) {
    LazyColumn(
        modifier = modifier
    ) {
        item {
            CenteredText(
                text = stringResource(R.string.picks_screen_title_content),
                modifier = Modifier.fillMaxWidth().padding(vertical = 12.dp)
            )
        }
        item {
            CenteredText(
                text = stringResource(R.string.picks_screen_description_or_content),
                style = MaterialTheme.typography.titleMedium
            )
        }
        items(intensifiers) { intensifier ->
            DifferentRadioButton(
                intensifier = intensifier,
                selected = ( selectedIntensifier == intensifier ),
                onSelected = { onIntensifierSelected(intensifier) }
            )
        }
        item {
            BigButton(stringResource(
                R.string.picks_screen_button_text),
                onClick = onSubmit,
                modifier = Modifier.padding(bottom = 16.dp)
            )
        }
        if (recommendedCoffee != null) {
            item {
                Column {
                    CenteredText(
                        text = stringResource(R.string.picks_screen_recommendation_quiz_result_text),
                        style = MaterialTheme.typography.titleMedium,
                        modifier = Modifier.fillMaxWidth().padding(vertical = 12.dp)
                    )
                    CoffeeCard(recommendedCoffee)
                }
            }
        }
    }
}