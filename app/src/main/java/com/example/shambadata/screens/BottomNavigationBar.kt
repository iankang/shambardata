package com.example.shambadata.screens

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.shambadata.navigation.BottomNavigation
import com.example.shambadata.ui.theme.ShambaDataTheme

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    val items = listOf(
        BottomNavigation.Events,
        BottomNavigation.Animals,
        BottomNavigation.Farms,
        BottomNavigation.Stats
    )

    BottomNavigation(
        backgroundColor = MaterialTheme.colors.background,
        contentColor = MaterialTheme.colors.onBackground,
        elevation = 12.dp
    ) {

        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        items.forEach { item ->
            BottomNavigationItem(
                icon = {
                    Icon(
                        painter = painterResource(id = item.icon),
                        modifier = Modifier.fillMaxSize(0.5f),
                        contentDescription = item.title,
                        tint = MaterialTheme.colors.onBackground
                    )
                },
                label = { Text(text = item.title, color = MaterialTheme.colors.onBackground) },
                selectedContentColor = MaterialTheme.colors.secondary,
                unselectedContentColor = MaterialTheme.colors.secondary.copy(0.4f),
                alwaysShowLabel = true,
                selected = currentRoute == item.route,
                onClick = {
                    if (currentRoute != item.route) {
                        navController.navigate(item.route)
                    }
                })
        }
    }

}

//@Preview(name = "day", uiMode = UI_MODE_NIGHT_NO, showBackground = true)
//@Preview(name = "dark", uiMode = UI_MODE_NIGHT_YES, showBackground = true)
//@Composable
//fun BottomNavigationBarPreview() {
//    ShambaDataTheme {
//        BottomNavigationBar(null)
//    }
//}
