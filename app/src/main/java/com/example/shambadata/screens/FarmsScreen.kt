package com.example.shambadata.screens

import android.content.res.Configuration
import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shambadata.models.ShambaDataResponseItem
import com.example.shambadata.ui.theme.ShambaDataTheme
import com.example.shambadata.viewmodels.FarmViewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun FarmsScreen(farmsViewModel: FarmViewModel, innerPadding: PaddingValues) {

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
            .wrapContentSize(Alignment.Center),
        contentPadding = innerPadding
    ) {
        items(items = farmsViewModel.farms) {
            FarmItem(it,farmsViewModel)
        }
    }
}

@Composable
fun FarmItem(farm: ShambaDataResponseItem? = null,farmsViewModel: FarmViewModel? = null) {
    val context = LocalContext.current
    val county = farmsViewModel?.getCountyFromCountyCode(farm?.countyCode!!)
    Log.e("county", county?.toString()!!)
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
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp),
                    painter = painterResource(id = id),
                    contentDescription = "farm Photo",
                    contentScale = ContentScale.FillBounds
                )
            }
            Row {
                FarmMetaData(
                    farmName = farm?.farmName,
                    farmLocation = county.name
                )
            }

        }

    }

}

@Composable
@Preview(name = "dayMeta", uiMode = Configuration.UI_MODE_NIGHT_NO, showBackground = true)
@Preview(name = "nightMeta", uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
fun FarmMetaData(
    farmName: String? = "Farm Name",
    farmLocation: String? = "Nairobi"
) {
    ShambaDataTheme {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colors.background)
        ) {
            Row(
                modifier = Modifier.padding(horizontal = 8.dp)
            ) {
                Text(
                    text = farmName!!,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Row {
                FarmLocation(farmLocation)
            }
        }
    }
}

@Composable
@Preview(name = "iconAndTextday", uiMode = Configuration.UI_MODE_NIGHT_NO, showBackground = true)
@Preview(name = "iconAndTextnight", uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
fun FarmLocation(countyCode: String? = null) {
    ShambaDataTheme {
        Row(
            modifier = Modifier.padding(top = 8.dp, bottom = 8.dp, start = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Icon(
                Icons.Outlined.LocationOn,
                null,
                tint = MaterialTheme.colors.primaryVariant
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = countyCode!!,
                color = MaterialTheme.colors.primaryVariant
            )
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
            ),
            null
        )
    }
}