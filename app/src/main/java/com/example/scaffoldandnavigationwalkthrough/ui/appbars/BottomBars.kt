package com.example.scaffoldandnavigationwalkthrough.ui.appbars

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.scaffoldandnavigationwalkthrough.data.TabItem

@Composable
// displays the bottom bar used in navigation
fun BottomBar(navController: NavController) {
    val backStackEntry = navController.currentBackStackEntryAsState()
    val tabs = listOf(
        TabItem("Home", Icons.Filled.Home, route = "home"),
        TabItem("Home", Icons.Filled.Info, route = "info"),
        TabItem("Favourite", Icons.Filled.Favorite, route = "settings")
    )
    NavigationBar {
        tabs.forEach{tab ->
            val selected = tab.route === backStackEntry.value?.destination?.route
            NavigationBarItem(
                selected = selected,
                onClick = { navController.navigate(tab.route) },
                label = { Text(tab.label) },
                icon = { Icon(
                    imageVector = tab.icon,
                    contentDescription = null
                ) }
            )
        }
    }
}