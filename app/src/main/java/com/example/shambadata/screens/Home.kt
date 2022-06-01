package com.example.shambadata.screens

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.material.primarySurface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.shambadata.navigation.BottomNavigation
import com.example.shambadata.navigation.Navigation
import com.example.shambadata.ui.theme.ShambaDataTheme

@Composable
fun HomeScreen(){
    val navController = rememberNavController()
    Scaffold(
        topBar = { TopAppBar(
            backgroundColor = MaterialTheme.colors.background,
            contentColor = MaterialTheme.colors.onBackground
        ) {

        }},
        bottomBar = { BottomNavigationBar(navController)},
        contentColor = MaterialTheme.colors.onBackground
    ) {
       Navigation(navController = navController)
    }
}

@Preview(name = "day", uiMode = UI_MODE_NIGHT_NO, showBackground = true)
@Preview(name = "night", uiMode = UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun HomeScreenPreview(){
    ShambaDataTheme {
        HomeScreen()
    }
}