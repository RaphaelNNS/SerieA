package com.example.seriea.ui.screens.settings

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScaffoldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.seriea.ui.theme.SerieATheme
import com.example.seriea.ui.theme.TextPrimary
import com.example.seriea.ui.components.GameCard
import com.example.seriea.ui.components.TopBar
import com.example.seriea.ui.components.GameCardSkeleton
import com.example.seriea.ui.components.tables.TableCell
import com.example.seriea.ui.components.tables.TableCellSkeleton
import com.example.seriea.ui.components.tables.tableHeader
import com.example.seriea.ui.screens.home.homeViewModel
import com.example.seriea.ui.theme.Surface


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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(
    viewModel: homeViewModel = viewModel()
) {
    Scaffold(
        Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        bottomBar = {
        },
        topBar = {
            TopBar()
        },
        contentWindowInsets = ScaffoldDefaults.contentWindowInsets

    ) { padding ->
        Spacer(Modifier.height(8.dp))
        Column (
            Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(padding)
                .padding(start = 8.dp, end = 8.dp)
        ){
            Text("SettingsScreen")
        }
    }
}








