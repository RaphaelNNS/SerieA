package com.example.seriea.ui.components.tables

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
import com.example.seriea.data.model.Standing
import com.example.seriea.data.model.TableEntry
import com.example.seriea.ui.theme.Surface
import com.example.seriea.ui.theme.TextPrimary
import com.example.seriea.ui.theme.TextSecondary

@Composable
fun TableCell(tableEntry: TableEntry) {

    var team = tableEntry.team
    var lost = tableEntry.lost
    var draw = tableEntry.draw
    var won = tableEntry.won
    var position = tableEntry.position.toString()
    var image = tableEntry.team.crest
    var points = tableEntry.points.toString()



    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
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
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(position, style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f))
                Spacer(Modifier.width(16.dp))
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(image)
                        .decoderFactory(SvgDecoder.Factory())
                        .build(),
                    contentDescription = "Escudo do time",
                    modifier = Modifier.size(32.dp)
                )
                Spacer(Modifier.width(8.dp))
                Column {
                    Text(team.name, style = MaterialTheme.typography.bodyLarge, color = MaterialTheme.colorScheme.onSurface)
                    Row {
                        Text("${won}V ", style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f))
                        Text("${draw}E ", style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f))
                        Text("${lost}D ", style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f))
                    }
                }
            }


            Text(
                text = points,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface
            )
        }
    }
}