package com.example.shambadata.screens

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shambadata.models.Schedule
import com.example.shambadata.ui.theme.ShambaDataTheme
import com.example.shambadata.viewmodels.EventsViewModel

@Composable
fun EventsScreen(
    eventsViewModel: EventsViewModel,
    innerPadding: PaddingValues
) {
    eventsViewModel.addSchedules()
    Log.e("scheduleList", eventsViewModel.scheduleList.toString())
    LazyColumn(
        contentPadding = innerPadding
    ) {
        items(items = eventsViewModel.scheduleList, itemContent = {
            EventItemCard(
                it
            )
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

                Column() {

                }
            }
        }
    }

}

@Composable
@Preview(name = "infoday", uiMode = UI_MODE_NIGHT_NO, showBackground = true)
@Preview(name = "infonight", uiMode = UI_MODE_NIGHT_YES, showBackground = true)
fun EventCardInfo(){
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
fun EventItem(schedule: Schedule? = Schedule(
    scheduleActivityName = "Dip",
    scheduleDate = "24/07/2022",
    animalId = "2",
    scheduleId = "4"

)) {
    EventItemCard(schedule = schedule!!)
}
