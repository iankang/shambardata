package com.example.shambadata.screens

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.shambadata.navigation.MainNavHost

@Composable
fun HomeScreen(authController: NavController) {
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
        MainNavHost(authController = authController, navController = navController)
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