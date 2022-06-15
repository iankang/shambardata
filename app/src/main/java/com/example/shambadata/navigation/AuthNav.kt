package com.example.shambadata.navigation

sealed class AuthNavigationScreens(val route: String) {
    object Login : AuthNavigationScreens("login")
    object Register : AuthNavigationScreens("register")
    object Main : AuthNavigationScreens("main")
}