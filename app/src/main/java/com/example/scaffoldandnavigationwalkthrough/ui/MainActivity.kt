package com.example.scaffoldandnavigationwalkthrough.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.scaffoldandnavigationwalkthrough.ui.navigation.ScaffoldApp
import com.example.scaffoldandnavigationwalkthrough.ui.theme.ScaffoldAndNavigationWalkthroughTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ScaffoldAndNavigationWalkthroughTheme {
                ScaffoldApp()
            }
        }
    }
}
