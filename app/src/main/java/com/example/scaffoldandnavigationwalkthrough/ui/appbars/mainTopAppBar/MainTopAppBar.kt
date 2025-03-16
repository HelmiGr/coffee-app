package com.example.scaffoldandnavigationwalkthrough.ui.appbars.mainTopAppBar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.scaffoldandnavigationwalkthrough.R
import com.example.scaffoldandnavigationwalkthrough.ui.components.TopBarIconButton

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainTopAppBar(title: String, navController: NavController, expanded: Boolean, onExpandedChange: (Boolean) -> Unit) {
        TopAppBar(
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.secondary,
                titleContentColor = MaterialTheme.colorScheme.primary
            ),
            title = { Text(text = title) },
            actions = {
                TopBarIconButton(
                    textResId = R.string.three_dots_for_more_icon_description,
                    icon = Icons.Filled.Menu,
                    onClick = { onExpandedChange(!expanded) }
                )
                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { onExpandedChange(false) }
                ) {
                    ItemForDropdownMenu(
                        textResId = R.string.dropdown_text_for_info,
                        onClick = { navController.navigate("info") }
                    )
                    ItemForDropdownMenu(
                        textResId = R.string.dropdown_text_for_settings,
                        onClick = { navController.navigate("settings") }
                    )
                }
            }
        )
}