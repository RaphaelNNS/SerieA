package com.example.seriea.ui.theme.components

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
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.seriea.ui.theme.Surface
import com.example.seriea.ui.theme.TextPrimary
import com.example.seriea.ui.theme.TextSecondary
import com.example.seriea.ui.theme.TextTertiary

@Composable
fun GameCard(){

    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = Surface
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
                Text("Brasileirão", style = MaterialTheme.typography.labelSmall, color = TextSecondary)
                Text("22 de abr. - 20:30", style = MaterialTheme.typography.labelSmall, color = TextSecondary)
            }
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Grêmio", style = MaterialTheme.typography.bodyLarge, color = TextPrimary)
                Text("VS", style = MaterialTheme.typography.bodySmall, color = TextTertiary)
                Text("Flamengo", style = MaterialTheme.typography.bodyLarge, color = TextPrimary)
            }
        }
    }
}