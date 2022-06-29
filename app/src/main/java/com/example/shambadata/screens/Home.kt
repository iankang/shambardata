package com.example.shambadata.screens

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.shambadata.navigation.MainNavHost
import com.example.shambadata.viewmodels.EventsViewModel
import com.example.shambadata.viewmodels.FarmViewModel
import com.example.shambadata.viewmodels.LivestockViewModel

@Composable
fun HomeScreen(
    authController: NavController,
    eventsViewModel: EventsViewModel,
    farmsViewModel: FarmViewModel,
    livestockViewModel: LivestockViewModel
) {
    val navController = rememberNavController()
    val scaffoldState = rememberScaffoldState()
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                backgroundColor = MaterialTheme.colors.background,
                contentColor = MaterialTheme.colors.onBackground
            ) {

            }
        },
        bottomBar = { BottomNavigationBar(navController) },
        contentColor = MaterialTheme.colors.onBackground
    ) { innerPadding ->
        MainNavHost(
            authController = authController,
            navController = navController,
            eventsViewModel = eventsViewModel,
            farmsViewModel = farmsViewModel,
            livestockViewModel = livestockViewModel,
            innerPadding
        )
    }
}

//@Preview(name = "day", uiMode = UI_MODE_NIGHT_NO, showBackground = true)
//@Preview(name = "night", uiMode = UI_MODE_NIGHT_YES, showBackground = true)
//@Composable
//fun HomeScreenPreview() {
//    ShambaDataTheme {
//        HomeScreen(null)
//    }
//}