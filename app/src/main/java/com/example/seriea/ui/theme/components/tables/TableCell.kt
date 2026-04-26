package com.example.seriea.ui.theme.components.tables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.decode.SvgDecoder
import coil.request.ImageRequest
import com.example.seriea.ui.theme.Surface
import com.example.seriea.ui.theme.TextPrimary
import com.example.seriea.ui.theme.TextSecondary

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