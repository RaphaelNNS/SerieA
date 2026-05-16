package com.example.seriea.ui.screens.settings

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.Language
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material3.ExperimentalMaterial3Api
import com.example.seriea.ui.components.Cell
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.seriea.ui.components.CellPosition
import com.example.seriea.ui.components.CellStyle
import com.example.seriea.ui.theme.SerieATheme
import com.example.seriea.ui.theme.ThemeViewModel




@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(
    themeViewModel: ThemeViewModel = viewModel()
) {

    val systemIsDark = isSystemInDarkTheme()


    Column(
        Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(start = 16.dp, end = 16.dp, top = 16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(
                text = "Configurações",
                style = MaterialTheme.typography.headlineSmall,
                color = MaterialTheme.colorScheme.onBackground
            )
            Text(
                text = "Personalize seu app de futebol",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.6f)
            )
        }

        Spacer(Modifier.height(16.dp))

        Column (
        ){
            Text(
                text = "Notificações",
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier.padding(bottom = 12.dp)
            )
            Cell(
                CellPosition.TOP,
                Modifier,
                "Modo escuro",
                "",
                onClickCard = { themeViewModel.toggleTheme(systemIsDark) },
                imageVector = if (isSystemInDarkTheme()) Icons.Default.DarkMode else Icons.Default.LightMode

            ) 
            Cell(
                CellPosition.BOTTOM,
                Modifier,
                "Idioma",
                description = "em breve",
                onClickCard = {},
                imageVector = Icons.Default.Language
            )
        }
        Spacer(Modifier.height(16.dp))

        Column (
        ){
            Text(
                text = "Aparência",
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier.padding(bottom = 12.dp)
            )
            Cell(
                CellPosition.TOP,
                Modifier,
                "Modo escuro",
                "",
                onClickCard = { themeViewModel.toggleTheme(systemIsDark) },
                imageVector = if (isSystemInDarkTheme()) Icons.Default.DarkMode else Icons.Default.LightMode
            )
            Cell(
                CellPosition.BOTTOM,
                Modifier,
                "Idioma",
                description = "em breve",
                onClickCard = {},
                imageVector = Icons.Default.Language
            )
        }


        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(
                text = "SerieA App © 2026",
                style = MaterialTheme.typography.labelSmall,
                color = Color(0xFF9CA3AF),
                textAlign = TextAlign.Center
            )

            Text(
                text = "Dados fornecidos por API-Football",
                style = MaterialTheme.typography.labelSmall,
                color = Color(0xFF9CA3AF),
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    device = "spec:width=550dp,height=1000dp"
)
@Composable
fun HomeScreenPreview() {
    SerieATheme {
        SettingsScreen()
    }
}






