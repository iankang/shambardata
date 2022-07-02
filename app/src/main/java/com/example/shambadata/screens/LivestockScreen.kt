package com.example.shambadata.screens

import android.content.res.Configuration
import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.shambadata.R
import com.example.shambadata.models.LiveStockCategoryResponseItem
import com.example.shambadata.ui.theme.ShambaDataTheme
import com.example.shambadata.viewmodels.LivestockViewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LiveStockScreen(
    livestockViewModel: LivestockViewModel? = null,
    innerPadding: PaddingValues? = null
) {
    Log.e("livestockAnimalItem", livestockViewModel?.dataWrangler?.animalMap.toString())
    val context = LocalContext.current
    val livestockCategoryList = remember{ livestockViewModel?.dataWrangler?.livestockMap?.values?.toList()!! }
    LazyVerticalGrid(
        cells = GridCells.Fixed(2),
        contentPadding = innerPadding!!,
        content = {
            items(livestockCategoryList) { item: LiveStockCategoryResponseItem ->
                val drawableId = remember(item.image) {
                    context.resources.getIdentifier(
                        item.image,
                        "drawable",
                        context.packageName
                    )
                }
                livestockCategoryCardItem(drawableId)
            }
        }
    )
}

@Preview(name = "dayCategory", uiMode = Configuration.UI_MODE_NIGHT_NO, showBackground = true)
@Preview(name = "nightCategory", uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun livestockCategoryCardItem(imageId:Int? = null) {

   Surface(
       modifier = Modifier
           .width(80.dp)
           .height(200.dp)
           .padding(12.dp),
       shape = RoundedCornerShape(4.dp),
       elevation = 4.dp
   ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = imageId ?: R.drawable.cow),
                contentDescription = "categoryImage",
                contentScale = ContentScale.FillBounds
            )
        }
    }

}

@Preview(name = "day", uiMode = Configuration.UI_MODE_NIGHT_NO, showBackground = true)
@Preview(name = "night", uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun LiveStockScreenPreview() {
    ShambaDataTheme {
        LiveStockScreen()
    }

}