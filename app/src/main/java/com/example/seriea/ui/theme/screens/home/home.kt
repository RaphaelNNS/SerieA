package com.example.seriea.ui.theme.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
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
import com.example.seriea.ui.theme.SerieATheme
import com.example.seriea.ui.theme.TextPrimary
import com.example.seriea.ui.theme.components.BottomBar
import com.example.seriea.ui.theme.components.GameCard
import com.example.seriea.ui.theme.components.TopBar
import com.example.seriea.ui.theme.components.Chips
import com.example.seriea.ui.theme.components.tables.TableCell
import com.example.seriea.ui.theme.components.tables.tableHeader


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
fun HomeScreen() {
    Scaffold(
        Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        bottomBar = {
            BottomBar()
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
                .fillMaxWidth()
                .padding(padding)
                .padding(start = 8.dp, end = 8.dp)
        ){
            Spacer(Modifier.height(8.dp))
            Spacer(Modifier.height(8.dp))
            Text("Jogos de Hoje" , style = MaterialTheme.typography.headlineSmall, color = TextPrimary)
            Spacer(Modifier.height(8.dp))
            GameCard()
            Spacer(Modifier.height(16.dp))
            Text("Proximos Jogos", style = MaterialTheme.typography.headlineSmall, color = TextPrimary)
            Spacer(Modifier.height(8.dp))
            NextMatches()
            Spacer(Modifier.height(8.dp))
            Row (horizontalArrangement = Arrangement.spacedBy(4.dp)){
                Chips("Todos", true)
                Chips("Brasileirão Série A", false)
            }
            Spacer(Modifier.height(8.dp))
            leagueTable()
        }
    }
}

@Composable
fun NextMatches() {
    for (x in 1..2){
        GameCard()
        Spacer(Modifier.height(8.dp))
    }
}

@Composable
fun leagueTable(){
    tableHeader("Classificação")
    for (x in 1..8){
        TableCell()
    }
}








