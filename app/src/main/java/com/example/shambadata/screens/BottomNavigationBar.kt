package com.example.shambadata.screens

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.shambadata.navigation.BottomNavigation

@Composable
fun BottomNavigationBar(navController: NavController?) {
    val items = listOf(
        BottomNavigation.Events,
        BottomNavigation.Animals,
        BottomNavigation.Farms,
        BottomNavigation.Stats
    )

    BottomNavigation(
        backgroundColor = MaterialTheme.colors.background,
        contentColor = MaterialTheme.colors.onBackground
    ) {

        val navBackStackEntry by navController?.currentBackStackEntryAsState()!!
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
                selectedContentColor = Color.White,
                unselectedContentColor = Color.White.copy(0.4f),
                alwaysShowLabel = true,
                selected = currentRoute == item.route,
                onClick = {
                    navController?.navigate(item.route) {
                        // Pop up to the start destination of the graph to
                        // avoid building up a large stack of destinations
                        // on the back stack as users select items
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }
                        // Avoid multiple copies of the same destination when
                        // reselecting the same item
                        launchSingleTop = true
                        // Restore state when reselecting a previously selected item
                        restoreState = true
                    }
                })
        }
    }

    @Preview(name = "day", uiMode = UI_MODE_NIGHT_NO, showBackground = true)
    @Preview(name = "dark", uiMode = UI_MODE_NIGHT_YES, showBackground = true)
    @Composable
    fun BottomNavigationBarPreview() {
        BottomNavigationBar(null)
    }
}