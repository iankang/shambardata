package com.example.shambadata.screens

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shambadata.ui.theme.ShambaDataTheme
import com.example.shambadata.viewmodels.FarmViewModel

@Composable
fun FarmsScreen(farmsViewModel: FarmViewModel) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
            .wrapContentSize(Alignment.Center)
    ) {
        Text(
            text = "Farms View",
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colors.onBackground,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center,
            fontSize = 25.sp
        )
    }
}

@Composable
fun FarmItem(){

        Card(
            modifier = Modifier.fillMaxWidth()
                .padding(8.dp)
        ) {
            Row {
                Text(text = "farmName")
            }
        }

}

@Preview(name = "day", uiMode = Configuration.UI_MODE_NIGHT_NO, showBackground = true)
@Preview(name = "night", uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun FarmItemPreview() {
    ShambaDataTheme {
        FarmItem()
    }

}