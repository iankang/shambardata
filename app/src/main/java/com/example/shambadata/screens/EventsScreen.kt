package com.example.shambadata.screens

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shambadata.R
import com.example.shambadata.models.Schedule
import com.example.shambadata.models.ScheduleItem
import com.example.shambadata.ui.theme.ShambaDataTheme
import com.example.shambadata.viewmodels.EventsViewModel
import java.util.*

@Composable
fun EventsScreen(
    eventsViewModel: EventsViewModel,
    innerPadding: PaddingValues
) {

    Log.e("scheduleList", eventsViewModel.dataWrangler.onlySchedules.toString())
    LazyColumn(
        contentPadding = innerPadding,
        modifier = Modifier.padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        items(items = eventsViewModel.dataWrangler.onlySchedules.toList(), itemContent = {
            ScheduleCard(it)
        })
    }
}

@Composable
fun EventItemCard(schedule: Schedule) {
    ShambaDataTheme {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            backgroundColor = MaterialTheme.colors.background
        ) {
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier
                        .padding(12.dp),
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = schedule.scheduleActivityName!!,
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,

                        )

                    Text(
                        text = schedule.scheduleDate!!
                    )
                }

                Column {

                }
            }
        }
    }

}

@Composable
@Preview(name = "infoday", uiMode = UI_MODE_NIGHT_NO, showBackground = true)
@Preview(name = "infonight", uiMode = UI_MODE_NIGHT_YES, showBackground = true)
fun EventCardInfo() {
    ShambaDataTheme {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            backgroundColor = MaterialTheme.colors.background
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Dip",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,

                    )

                Text(
                    text = "24/07/2022",
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
            }

            Row {

            }
        }
    }
}

@Composable
@Preview(name = "day", uiMode = UI_MODE_NIGHT_NO, showBackground = true)
@Preview(name = "night", uiMode = UI_MODE_NIGHT_YES, showBackground = true)
fun EventItem(
    schedule: Schedule? = Schedule(
        scheduleActivityName = "Dip",
        scheduleDate = "24/07/2022",
        animalId = "2",
        scheduleId = "4"

    )
) {
    EventItemCard(schedule = schedule!!)
}

@Composable
@Preview(name = "daySchedule", uiMode = UI_MODE_NIGHT_NO, showBackground = true)
@Preview(name = "nightSchedule", uiMode = UI_MODE_NIGHT_YES, showBackground = true)
fun ScheduleCard(schedule: ScheduleItem? = null) {
//    val drawableId = remember(schedule?.animalI) {
//        context.resources.getIdentifier(
//            item.image,
//            "drawable",
//            context.packageName
//        )
//    }
    val context = LocalContext.current
    val drawableId = remember(schedule?.animalItem?.livestockAndBreedItem?.categoryImage) {
        context.resources.getIdentifier(
            schedule?.animalItem?.livestockAndBreedItem?.categoryImage ?: "cow",
            "drawable",
            context.packageName
        )
    }
    ShambaDataTheme {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(horizontal = 4.dp),
            color = MaterialTheme.colors.background,
            contentColor = MaterialTheme.colors.onBackground,
            elevation = 4.dp
        ) {
            Column {

                Image(
                    painter = painterResource(id = drawableId),
                    contentDescription = "categoryImage",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(180.dp),
                    contentScale = ContentScale.FillWidth
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = schedule?.scheduleActivityName?.replaceFirstChar {
                            if (it.isLowerCase()) it.titlecase(
                                Locale.ENGLISH
                            ) else it.toString()
                        }!!,
                        fontSize = 24.sp,
                        color = MaterialTheme.colors.onBackground
                    )

                    Text(
                        text = schedule.scheduleDate!!,
                        fontSize = 18.sp,
                        color = MaterialTheme.colors.onBackground
                    )
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Category: ${schedule?.animalItem?.livestockAndBreedItem?.species}",
                        fontSize = 18.sp,
                        color = MaterialTheme.colors.onBackground
                    )

                    Text(
                        text = "Animal Tag: ${schedule?.animalItem?.animalNameOrTag}",
                        fontSize = 18.sp,
                        color = MaterialTheme.colors.onBackground
                    )
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 4.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Age: ${schedule?.animalItem?.dob} years",
                        fontSize = 18.sp,
                        color = MaterialTheme.colors.onBackground
                    )

                    Text(
                        text = "Sex: ${schedule?.animalItem?.sex}",
                        fontSize = 18.sp,
                        color = MaterialTheme.colors.onBackground
                    )
                }
            }

        }
    }
}
