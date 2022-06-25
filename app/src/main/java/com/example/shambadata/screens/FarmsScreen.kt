package com.example.shambadata.screens

import android.content.res.Configuration
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCompositionContext
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shambadata.models.ShambaDataResponseItem
import com.example.shambadata.ui.theme.ShambaDataTheme
import com.example.shambadata.viewmodels.FarmViewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun FarmsScreen(farmsViewModel: FarmViewModel, innerPadding: PaddingValues) {

    LazyVerticalGrid(
        cells = GridCells.Fixed(2),
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
            .wrapContentSize(Alignment.Center),
        contentPadding = innerPadding
    ) {
       items(items = farmsViewModel.farms){
           FarmItem(it)
       }
    }
}

@Composable
fun FarmItem(farm:ShambaDataResponseItem? = null){
        val context = LocalContext.current
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            backgroundColor = MaterialTheme.colors.background,
            contentColor = MaterialTheme.colors.onBackground,
            elevation = 4.dp,

        ) {

            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                Row {
                    val id: Int = context.resources
                        .getIdentifier(farm?.farmProfile!!, "drawable", context.packageName)
                    Image(
                        modifier = Modifier.fillMaxWidth().height(300.dp),
                        painter = painterResource(id = id),
                        contentDescription = "farm Photo",
                        contentScale = ContentScale.FillBounds
                        )
                }
                Row {
                    Text(
                        text = farm?.farmName!!,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

        }

}

@Preview(name = "day", uiMode = Configuration.UI_MODE_NIGHT_NO, showBackground = true)
@Preview(name = "night", uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun FarmItemPreview() {
    ShambaDataTheme {
        FarmItem(
            ShambaDataResponseItem(
            areaInMetresSquared = "10000",
                farmProfile = "shamba.jpg"
        )
        )
    }

}