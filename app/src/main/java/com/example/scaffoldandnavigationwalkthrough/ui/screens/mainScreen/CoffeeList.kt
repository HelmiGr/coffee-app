package com.example.scaffoldandnavigationwalkthrough.ui.screens.mainScreen

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.scaffoldandnavigationwalkthrough.R
import com.example.scaffoldandnavigationwalkthrough.models.Coffee
import com.example.scaffoldandnavigationwalkthrough.ui.components.BigButton
import com.example.scaffoldandnavigationwalkthrough.ui.components.CenteredText
import com.example.scaffoldandnavigationwalkthrough.ui.components.CoffeeCard

// list of individual coffees with a button at the end to do something
@Composable
fun CoffeeList(modifier: Modifier = Modifier, coffees: List<Coffee>, onShowMore: () -> Unit) {
    LazyColumn(
        modifier = modifier
    ) {
        item {
            CenteredText(
                text = stringResource(R.string.main_screen_title_content),
                modifier = Modifier.fillMaxWidth().padding(vertical = 12.dp),
            )
        }
        items(coffees) { coffee ->
            CoffeeCard(coffee)
        }
        item {
            BigButton(stringResource(R.string.main_screen_button_text), onClick = onShowMore, modifier = Modifier.padding(16.dp))
        }
    }
}
