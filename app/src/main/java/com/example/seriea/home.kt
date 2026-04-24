package com.example.seriea

import android.R
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Arrangement.Absolute.spacedBy
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScaffoldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.decode.SvgDecoder
import coil.request.ImageRequest
import com.example.seriea.ui.theme.Background
import com.example.seriea.ui.theme.BluePrimary
import com.example.seriea.ui.theme.BluePrimaryDark
import com.example.seriea.ui.theme.Border
import com.example.seriea.ui.theme.SerieATheme
import com.example.seriea.ui.theme.Surface
import com.example.seriea.ui.theme.TextPrimary
import com.example.seriea.ui.theme.TextSecondary
import com.example.seriea.ui.theme.components.GameCard
import com.example.seriea.ui.theme.components.TopBar
import com.example.seriea.ui.theme.components.Chips
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



@Composable
fun TodayMatches() {
    Column(
    ) {

    }
}
@Composable
fun TableCell() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        colors = CardDefaults.cardColors(containerColor = Surface),
        shape = RectangleShape,
        elevation = CardDefaults.cardElevation(2.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // Lado esquerdo
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("1", style = MaterialTheme.typography.bodyMedium, color = TextSecondary)
                Spacer(Modifier.width(16.dp))
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data("https://crests.football-data.org/764.svg")
                        .decoderFactory(SvgDecoder.Factory())
                        .build(),
                    contentDescription = "Escudo do time",
                    modifier = Modifier.size(32.dp)
                )
                Spacer(Modifier.width(8.dp))
                Column {
                    Text("Flamengo", style = MaterialTheme.typography.bodyLarge, color = TextPrimary)
                    Row {
                        Text("14V ", style = MaterialTheme.typography.labelSmall, color = TextSecondary)
                        Text("3E ", style = MaterialTheme.typography.labelSmall, color = TextSecondary)
                        Text("2D ", style = MaterialTheme.typography.labelSmall, color = TextSecondary)
                    }
                }
            }


            Text(
                text = "29 pts",
                style = MaterialTheme.typography.bodyMedium,
                color = TextPrimary
            )
        }
    }
}



@Composable
fun BottomBar() {
    Column (modifier = Modifier.fillMaxWidth()){
        HorizontalDivider(thickness = 1.dp, color = Border)
        Box(
            modifier = Modifier
                .background(Surface)
                .fillMaxWidth()
                .height(48.dp)
        ){
            Row(modifier = Modifier
                .fillMaxSize()
                .padding(4.dp), horizontalArrangement = spacedBy(8.dp) ) {
                Column(
                    modifier = Modifier.weight(1f)
                ){ Box(
                    Modifier
                        .fillMaxSize()
                        .background(BluePrimary)
                ) {

                }
                }
                Column(
                    modifier = Modifier.weight(1f)
                ){ Box(
                    Modifier
                        .fillMaxSize()
                        .background(BluePrimaryDark)
                ) {

                }
                }
                Column(
                    modifier = Modifier.weight(1f)
                ){ Box(
                    Modifier
                        .fillMaxSize()
                        .background(BluePrimary)
                ) {

                }
                }
            }
        }
        Spacer(Modifier.navigationBarsPadding().background(Surface))
    }

}



