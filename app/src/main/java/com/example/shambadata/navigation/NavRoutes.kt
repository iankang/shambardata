package com.example.shambadata.navigation

sealed class NavRoutes(val route:String){
    object LoginScreen : NavRoutes("login_screen")
    object RegisterScreen : NavRoutes("register_screen")
    object AppScaffold : NavRoutes("app_scaffold")
}
