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
    eventsViewModel: EventsViewModel
) {
    eventsViewModel.addSchedules()
    Log.e("scheduleList", eventsViewModel.scheduleList.toString())
    LazyColumn {
        items(items = eventsViewModel.scheduleList, itemContent = {
            EventItemCard(
                it
            )
        })
    }
}

@Composable
//@Preview(name = "day", uiMode = UI_MODE_NIGHT_NO)
//@Preview(name = "night", uiMode = UI_MODE_NIGHT_YES)
fun EventItemCard(schedule: Schedule) {
    ShambaDataTheme {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            backgroundColor = MaterialTheme.colors.background
        ) {
            Column(
                modifier = Modifier.fillMaxWidth()
                    .padding(horizontal = 12.dp),
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = schedule.scheduleActivityName!!,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,

                )
                
                Text(
                    text = schedule?.scheduleDate!!
                )
            }
        }
    }

}

@Composable
fun EventItem(schedule: Schedule? = null) {
    Card {
        Text(text = schedule?.scheduleActivityName!!)
    }
}

//@Preview(name = "day", uiMode = UI_MODE_NIGHT_NO, showBackground = true)
//@Preview(name = "night", uiMode = UI_MODE_NIGHT_YES, showBackground = true)
//@Composable
//fun EventsScreenPreview() {
//    ShambaDataTheme {
//        EventsScreen()
//    }
//
//}