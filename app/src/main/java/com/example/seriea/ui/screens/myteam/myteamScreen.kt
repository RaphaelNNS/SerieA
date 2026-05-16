package com.example.seriea.ui.screens.myteam

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.seriea.ui.screens.home.homeViewModel
import com.example.seriea.ui.theme.SerieATheme


@Preview(
    showBackground = true,
    showSystemUi = true,
    device = "spec:width=550dp,height=1000dp"
)
@Composable
fun HomeScreenPreview() {
    SerieATheme {
        MyteamScreen()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyteamScreen(
    viewModel: homeViewModel = viewModel()
) {
    Spacer(Modifier.height(8.dp))
    Column (
        Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(start = 8.dp, end = 8.dp)
    ){
        Text("myTeamScreen")
    }
}








