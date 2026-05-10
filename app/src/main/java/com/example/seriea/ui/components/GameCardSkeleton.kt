package com.example.seriea.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.seriea.ui.screens.home.HomeScreen
import com.example.seriea.ui.shared.shimmerBrush
import com.example.seriea.ui.theme.SerieATheme
import com.example.seriea.ui.theme.Surface

@Composable
fun GameCardSkeleton() {
    val brush = shimmerBrush()

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 12.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Box(
                    modifier = Modifier
                        .height(12.dp)
                        .width(120.dp)
                        .background(brush, RoundedCornerShape(4.dp))
                )
                Box(
                    modifier = Modifier
                        .height(12.dp)
                        .width(60.dp)
                        .background(brush, RoundedCornerShape(4.dp))
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .height(16.dp)
                        .weight(6f)
                        .background(brush, RoundedCornerShape(4.dp))
                )
                Spacer(Modifier.width(8.dp))
                Box(
                    modifier = Modifier
                        .height(16.dp)
                        .weight(1f)
                        .background(brush, RoundedCornerShape(4.dp))
                )
                Spacer(Modifier.width(8.dp))
                Box(
                    modifier = Modifier
                        .height(16.dp)
                        .weight(6f)
                        .background(brush, RoundedCornerShape(4.dp))
                )
            }
        }
    }

}
@Preview(
    showBackground = true,
    showSystemUi = true,
    device = "spec:width=550dp,height=1000dp"
)
@Composable
fun HomeScreenPreview() {
    SerieATheme {
        Row {
            Spacer(Modifier.height(80.dp))
            GameCardSkeleton()
        }

    }
}