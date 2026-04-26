package com.example.seriea.ui.theme.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement.Absolute.spacedBy
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.seriea.ui.theme.BluePrimary
import com.example.seriea.ui.theme.BluePrimaryDark
import com.example.seriea.ui.theme.Border
import com.example.seriea.ui.theme.Surface

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
