package com.example.shambadata.navigation

sealed class NavRoutes(val route:String){
    object Login : NavRoutes("signin")
    object Register : NavRoutes("register")
    object Home : NavRoutes("home")
}
