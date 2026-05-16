package com.example.seriea

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.seriea.ui.components.BottomBar
import com.example.seriea.ui.components.TopBar
import com.example.seriea.ui.navigation.Screen
import com.example.seriea.ui.theme.SerieATheme
import com.example.seriea.ui.screens.home.HomeScreen
import com.example.seriea.ui.screens.myteam.MyteamScreen
import com.example.seriea.ui.screens.settings.SettingsScreen
import com.example.seriea.ui.theme.ThemeViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {

            val themeViewModel: ThemeViewModel = viewModel()
            val systemIsDark = isSystemInDarkTheme()
            val isDark = themeViewModel.isDarkTheme ?: systemIsDark


            SerieATheme(darkTheme = isDark) {
                val navController = rememberNavController()

                Scaffold(
                    topBar = { TopBar() },
                    bottomBar = { BottomBar(navController) }
                ) { padding ->
                    NavHost(
                        navController = navController,
                        startDestination = Screen.Home.route,
                        modifier = Modifier.padding(padding)
                    ) {
                        composable(Screen.Home.route) { HomeScreen() }
                        composable(Screen.MyTeam.route) { MyteamScreen() }
                        composable(Screen.Settings.route) { SettingsScreen(themeViewModel = themeViewModel) }
                    }
                }
            }
        }
    }
}



@Preview(
    showBackground = true,
    showSystemUi = true,
    device = "spec:width=411dp,height=891dp"
)
@Composable
fun GreetingPreview() {
    SerieATheme {
        HomeScreen()
    }
}