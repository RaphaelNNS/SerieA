package com.example.seriea.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.seriea.ui.navigation.Screen

@Composable
fun BottomBar(navController: NavController) {

    val navItemColors = NavigationBarItemDefaults.colors(
        selectedIconColor = MaterialTheme.colorScheme.primary,
        selectedTextColor = MaterialTheme.colorScheme.primary,
        indicatorColor = Color.Transparent,
        unselectedIconColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f),
        unselectedTextColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f),
    )

    val currentRoute = navController
        .currentBackStackEntryAsState().value?.destination?.route


    Column(Modifier.fillMaxWidth()) {
        HorizontalDivider(thickness = 2.dp, color = MaterialTheme.colorScheme.outlineVariant)
        NavigationBar(
            containerColor = MaterialTheme.colorScheme.surface,
            tonalElevation = 0.dp,
            modifier = Modifier.height(104.dp)
        ) {
            NavigationBarItem(
                selected = currentRoute == Screen.Home.route,
                onClick = { navController.navigate(Screen.Home.route) },
                icon = { Icon(Icons.Default.Home, contentDescription = null) },
                label = { Text("Início") },
                colors = navItemColors
            )
            NavigationBarItem(
                selected = currentRoute == Screen.MyTeam.route,
                onClick = { navController.navigate(Screen.MyTeam.route) },
                icon = { Icon(Icons.Default.Favorite, contentDescription = null) },
                label = { Text("Meu Time") },
                colors = navItemColors
            )
            NavigationBarItem(
                selected = currentRoute == Screen.Settings.route,
                onClick = { navController.navigate(Screen.Settings.route) },
                icon = { Icon(Icons.Default.Settings, contentDescription = null) },
                label = { Text("Settings") },
                colors = navItemColors
            )
        }
    }

}
