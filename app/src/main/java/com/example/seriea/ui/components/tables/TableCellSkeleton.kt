package com.example.seriea.ui.components.tables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import com.example.seriea.ui.shared.shimmerBrush
import com.example.seriea.ui.theme.Surface

@Composable
fun TableCellSkeleton() {
    val brush = shimmerBrush()

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
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                // posição
                Box(modifier = Modifier.size(16.dp, 12.dp).background(brush, RoundedCornerShape(4.dp)))
                // escudo
                Box(modifier = Modifier.size(32.dp).background(brush, CircleShape))
                Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                    // nome
                    Box(modifier = Modifier.size(100.dp, 12.dp).background(brush, RoundedCornerShape(4.dp)))
                    // stats
                    Box(modifier = Modifier.size(60.dp, 8.dp).background(brush, RoundedCornerShape(4.dp)))
                }
            }
            // pontos
            Box(modifier = Modifier.size(24.dp , 12.dp).background(brush, RoundedCornerShape(4.dp)))
        }
    }
}