package com.example.scaffoldandnavigationwalkthrough.ui.appbars.mainTopAppBar

import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource

@Composable
fun ItemForDropdownMenu(
    textResId: Int, // string resource id which should be used in the dropdown item
    onClick: () -> Unit
) {
    DropdownMenuItem(
        text = {
            Text(
                text = stringResource(textResId),
                style = MaterialTheme.typography.bodyLarge
            )
        },
        onClick = { onClick() }
    )
}