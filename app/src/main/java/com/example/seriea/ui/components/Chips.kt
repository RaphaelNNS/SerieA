package com.example.seriea.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.seriea.ui.theme.BluePrimary
import com.example.seriea.ui.theme.Border
import com.example.seriea.ui.theme.DarkTextPrimary
import com.example.seriea.ui.theme.Surface
import com.example.seriea.ui.theme.TextPrimary

@Composable
fun Chips(text: String, initialSelected: Boolean) {


    var selected by remember { mutableStateOf(initialSelected) }
    val chipsShape = RoundedCornerShape(32.dp)

    Box(
        modifier = Modifier
            .background(
                color = if (selected) BluePrimary else Surface,
                shape = chipsShape
            )
            .clip(chipsShape)
            .border(width = if (!selected) 1.dp else 0.dp, Border, shape = chipsShape)
            .clickable{selected = !selected}

    )
    {
        Row(modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp)) {
            Text(
                text,
                style = MaterialTheme.typography.labelLarge,
                color = if (selected) DarkTextPrimary else TextPrimary,
            )
        }
    }
}

