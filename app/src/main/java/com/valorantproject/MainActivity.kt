package com.valorantproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.valorantproject.core.ui.theme.ValorantProjectTheme
import com.valorantproject.navigation.SetupNavGraph
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            ValorantProjectTheme(darkTheme = true) {
                val navController = rememberNavController()

                SetupNavGraph(navController = navController)
            }
        }
    }
}