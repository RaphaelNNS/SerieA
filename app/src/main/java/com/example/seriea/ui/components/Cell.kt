package com.example.seriea.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.seriea.ui.screens.settings.SettingsScreen
import com.example.seriea.ui.theme.SerieATheme

@Composable
fun Cell(
    cellPosition: CellPosition? = null,
    modifier: Modifier = Modifier,
    title: String,
    description: String = "",
    onClickCard: (() -> Unit)? = null,
    imageVector: ImageVector? = null,
    cellStyle: CellStyle? = null,
    isChecked: Boolean? = null,
    onCheckedChange: ((Boolean) -> Unit)? = null
) {


    val cellShape = if(cellPosition != null){
        RoundedCornerShape(topEnd = if(cellPosition == CellPosition.TOP) 12.dp else 0.dp, topStart = if(cellPosition == CellPosition.TOP) 12.dp else 0.dp, bottomStart = if(cellPosition == CellPosition.BOTTOM) 12.dp else 0.dp, bottomEnd = if(cellPosition == CellPosition.BOTTOM) 12.dp else 0.dp)
    } else {
        RoundedCornerShape(topEnd = 12.dp, topStart = 12.dp, bottomStart = 12.dp, bottomEnd = 12.dp)
    }

    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(72.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        shape = cellShape,
        elevation = CardDefaults.cardElevation(4.dp),
        onClick = onClickCard ?: {}
    ) {
        Column {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {

                    if(imageVector != null){
                        Icon(
                            imageVector = imageVector,
                            contentDescription = "changesColor"
                        )
                    }
                    Spacer(Modifier.width(8.dp))
                    Column(
                        verticalArrangement = Arrangement.Top,
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(
                            title,
                            style = MaterialTheme.typography.bodyLarge,
                            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
                        )
                        if (!description.isBlank()){
                            Text(
                                description,
                                style = MaterialTheme.typography.labelSmall,
                                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.4f)
                            )
                        }
                    }
                    if (cellStyle == CellStyle.SWITCH){

                        Switch(
                            checked = isChecked ?: false,
                            onCheckedChange = onCheckedChange,
                            colors = SwitchDefaults.colors(
                                checkedThumbColor = MaterialTheme.colorScheme.surface,
                                checkedTrackColor = MaterialTheme.colorScheme.primary,
                                uncheckedThumbColor = MaterialTheme.colorScheme.surface,
                                uncheckedTrackColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.3f),
                                uncheckedBorderColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.2f)
                            )
                        )
                    } else if (cellStyle == CellStyle.ARROW) {
                        Icon(
                            imageVector = Icons.Default.ChevronRight,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.4f)
                        )
                    }
                }
            }
        }
    }
}

enum class CellPosition{
    TOP, MIDDLE, BOTTOM
}

enum class CellStyle{
    SWITCH, NEUTRAL, ARROW
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    device = "spec:width=550dp,height=1000dp"
)
@Composable
fun cellPreview() {
    SerieATheme(darkTheme = true) {
        SettingsScreen()
    }
}
