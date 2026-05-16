package com.example.seriea.ui.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object MyTeam : Screen("myTeam")
    object Settings : Screen("settings")
}