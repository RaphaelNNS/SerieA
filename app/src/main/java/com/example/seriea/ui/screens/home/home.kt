package com.example.seriea.ui.screens.home

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
import com.example.seriea.ui.theme.Surface


@Preview(
    showBackground = true,
    showSystemUi = true,
    device = "spec:width=550dp,height=1000dp"
)
@Composable
fun HomeScreenPreview() {
    SerieATheme {
        HomeScreen()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
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
            Spacer(Modifier.height(8.dp))
            Spacer(Modifier.height(8.dp))
            Text("Proximos Jogos", style = MaterialTheme.typography.headlineSmall, color = (MaterialTheme.colorScheme.onBackground))
            Spacer(Modifier.height(8.dp))
            val lastMatches = viewModel.matchesList.filter { it.status == "TIMED" || it.status == "SCHEDULED" }
                .sortedBy { it.utcDate }
                .take(3)
            if (!viewModel.isLoading){
                lastMatches.forEach {
                    GameCard(it)
                    Spacer(Modifier.height(8.dp))
                }
            }else{
                repeat(2){
                    GameCardSkeleton()
                    Spacer(Modifier.height(8.dp))
                }
            }

            Spacer(Modifier.height(8.dp))
            NextMatches()
            Spacer(Modifier.height(8.dp))
            Spacer(Modifier.height(8.dp))
            tableHeader("Classificação")
            if (!viewModel.isLoading){
                for (entry in viewModel.standingsResponse){
                    TableCell(entry)
                }
            }else{
                repeat(20){
                    TableCellSkeleton()
                }
            }
            Box(
                Modifier.background(
                    color = MaterialTheme.colorScheme.surface,
                    shape = RoundedCornerShape(
                        bottomEnd = 16.dp,
                        bottomStart = 16.dp
                    )
                ).height(24.dp).fillMaxWidth()
            ) {
            }
            Spacer(Modifier.height(8.dp))
        }
    }
}

@Composable
fun NextMatches() {

}







