package com.example.shambadata.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.shambadata.R
import com.example.shambadata.screens.EventsScreen
import com.example.shambadata.screens.FarmsScreen
import com.example.shambadata.screens.LiveStockScreen
import com.example.shambadata.screens.StatsScreen
import com.example.shambadata.viewmodels.EventsViewModel
import com.example.shambadata.viewmodels.FarmViewModel

sealed class BottomNavigation(var route:String, var icon:Int, var title:String){
    object Events: BottomNavigation("events", R.drawable.ic_baseline_list_alt_24, "Events")
    object Farms: BottomNavigation("farms",R.drawable.ic_baseline_maps_home,"Farms")
    object Animals:BottomNavigation("animals",R.drawable.ic_cow_outline,"Livestock")
    object Stats:BottomNavigation("stats",R.drawable.ic_baseline_auto_graph_24,"Stats")
}

@Composable
fun MainNavHost(
    authController: NavController,
    navController: NavHostController,
    eventsViewModel: EventsViewModel,
    farmsViewModel: FarmViewModel
){
    NavHost(navController = navController, startDestination = BottomNavigation.Events.route ){
        composable(BottomNavigation.Events.route) {
            EventsScreen(eventsViewModel)
        }
        composable(BottomNavigation.Animals.route) {
            LiveStockScreen()
        }
        composable(BottomNavigation.Farms.route) {
            FarmsScreen(farmsViewModel)
        }
        composable(BottomNavigation.Stats.route) {
            StatsScreen()
        }
    }
}


