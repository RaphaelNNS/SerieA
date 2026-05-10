package com.example.seriea.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.seriea.data.model.Match
import com.example.seriea.ui.theme.Surface
import com.example.seriea.ui.theme.TextPrimary
import com.example.seriea.ui.theme.TextSecondary
import com.example.seriea.ui.theme.TextTertiary
import java.text.SimpleDateFormat
import java.util.Locale
import java.util.TimeZone

@Composable
fun GameCard(match: Match){

    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        )


    ) {
        Column(
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 12.dp)
                .fillMaxWidth()
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp)
            ) {
                Text(match.competition.name, style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f))
                Text(utcToBrasilia(match.utcDate), style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f))
            }
            Row(
                
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(match.homeTeam.name, style = MaterialTheme.typography.bodyLarge, color = MaterialTheme.colorScheme.onSurface, modifier = Modifier.weight(6f))
                Text("VS", style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.4f), modifier = Modifier.weight(1f))
                Text(match.awayTeam.name, style = MaterialTheme.typography.bodyLarge, color = MaterialTheme.colorScheme.onSurface, modifier = Modifier.weight(6f), textAlign = TextAlign.End)
            }
        }
    }
}

fun utcToBrasilia(utcDate: String): String {
    val input = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault())
    input.timeZone = TimeZone.getTimeZone("UTC")

    val output = SimpleDateFormat("dd/MM\nHH:mm", Locale.getDefault())
    output.timeZone = TimeZone.getTimeZone("America/Sao_Paulo")

    return output.format(input.parse(utcDate)!!)
}
