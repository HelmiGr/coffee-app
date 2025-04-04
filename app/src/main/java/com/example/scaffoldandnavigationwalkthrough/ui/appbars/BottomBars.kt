package com.example.scaffoldandnavigationwalkthrough.ui.appbars

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.scaffoldandnavigationwalkthrough.data.TabItem
import com.example.scaffoldandnavigationwalkthrough.ui.navigation.Routes

@Composable
// displays the bottom bar used in navigation
fun BottomBar(navController: NavController) {
    val backStackEntry = navController.currentBackStackEntryAsState()
    val tabs = listOf(
        TabItem("Home", Icons.Filled.Home, route = Routes.HOME),
        TabItem("Info", Icons.Filled.Info, route = Routes.INFO),
        TabItem("Picks", Icons.Filled.Favorite, route = Routes.PICKS)
    )
    NavigationBar(
        containerColor = MaterialTheme.colorScheme.secondary
    ) {
        tabs.forEach{tab ->
            val selected = tab.route === backStackEntry.value?.destination?.route
            NavigationBarItem(
                selected = selected,
                onClick = { navController.navigate(tab.route) },
                label = { Text(
                    tab.label,
                    style = MaterialTheme.typography.bodyLarge
                ) },
                icon = { Icon(
                    imageVector = tab.icon,
                    contentDescription = null
                ) },
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = MaterialTheme.colorScheme.tertiary,
                    selectedIconColor = MaterialTheme.colorScheme.primary,
                    unselectedIconColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.7f),
                    selectedTextColor = MaterialTheme.colorScheme.primary,
                    unselectedTextColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.7f),
                )
            )
        }

    }
}