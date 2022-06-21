package com.example.shambadata.screens

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
            EventItem(
                it
            )
        })
    }
}

@Composable
@Preview(name = "day", uiMode = UI_MODE_NIGHT_NO)
@Preview(name = "night", uiMode = UI_MODE_NIGHT_YES)
fun EventItem() {
    ShambaDataTheme {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            backgroundColor = MaterialTheme.colors.background
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "vaccination"
                )
                
                Text(
                    text = "25/07/2022"
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