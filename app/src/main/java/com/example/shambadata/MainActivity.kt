package com.example.shambadata

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.example.shambadata.navigation.AuthNavigationScreens
import com.example.shambadata.navigation.BottomNavigation
import com.example.shambadata.navigation.NavRoutes
import com.example.shambadata.screens.*
import com.example.shambadata.ui.theme.ShambaDataTheme
import com.example.shambadata.viewmodels.LoginViewModel
import com.example.shambadataapi.repository.ShambaDataApi
import com.example.shambadataapi.utils.SessionManager
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {

    private val shambaDataApi: ShambaDataApi by inject()
    private val loginViewModel by viewModel<LoginViewModel>()
    private lateinit var sessionManager: SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sessionManager = SessionManager(this)

        setContent {
            ShambaDataTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()

                    NavHost(navController, startDestination = AuthNavigationScreens.Login.route) {
                        composable(AuthNavigationScreens.Login.route) {
                            LoginScreen(
                                navController,
                                loginViewModel
                            )
                        }
                        composable(AuthNavigationScreens.Register.route) { Register(navController) }
                        composable(AuthNavigationScreens.Main.route) { HomeScreen(navController) }
                    }
                }

            }
        }
    }
}


fun NavGraphBuilder.loginGraph(
    navController: NavController,
    loginViewModel: LoginViewModel
) {

    composable(NavRoutes.LoginScreen.route) {
        LoginScreen(
            navController = navController,
            loginViewModel = loginViewModel
        )
    }

    composable(NavRoutes.RegisterScreen.route) {
        Register(navController = navController)
    }

    composable(NavRoutes.AppScaffold.route) {
        HomeScreen(navController)
    }
}

fun NavGraphBuilder.bottomSheetGraph(
    navController: NavController
) {
    navigation(
        startDestination = BottomNavigation.Events.route,
        route = NavRoutes.AppScaffold.route
    ) {
        composable(BottomNavigation.Events.route) {
            EventsScreen()
        }
        composable(BottomNavigation.Animals.route) {
            LiveStockScreen()
        }
        composable(BottomNavigation.Farms.route) {
            FarmsScreen()
        }
        composable(BottomNavigation.Stats.route) {
            StatsScreen()
        }
    }
}
