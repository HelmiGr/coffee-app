package com.example.scaffoldandnavigationwalkthrough

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
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

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ScaffoldAndNavigationWalkthroughTheme {}
}