package com.example.shambadata

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.shambadata.navigation.AuthNavigationScreens
import com.example.shambadata.screens.HomeScreen
import com.example.shambadata.ui.theme.ShambaDataTheme
import com.example.shambadata.viewmodels.EventsViewModel
import com.example.shambadata.viewmodels.FarmViewModel
import com.example.shambadata.viewmodels.LivestockViewModel
import com.example.shambadata.viewmodels.LoginViewModel
import com.example.shambadataapi.repository.ShambaDataApi
import com.example.shambadataapi.utils.SessionManager
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {

    private val shambaDataApi: ShambaDataApi by inject()
    private val loginViewModel by viewModel<LoginViewModel>()
    private val eventsViewModel by viewModel<EventsViewModel>()
    private val farmsViewModel by viewModel<FarmViewModel>()
    private val livestockViewModel by viewModel<LivestockViewModel>()

    //    private val values:List<ShambaDataJSONResponse> by inject()
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

                    NavHost(navController, startDestination = AuthNavigationScreens.Main.route) {
//                        composable(AuthNavigationScreens.Login.route) {
//                            LoginScreen(
//                                navController,
//                                loginViewModel,
//                                sessionManager
//                            )
//                        }
//                        composable(AuthNavigationScreens.Register.route) { Register(navController) }
                        composable(AuthNavigationScreens.Main.route) {
                            HomeScreen(
                                navController,
                                eventsViewModel = eventsViewModel,
                                farmsViewModel = farmsViewModel,
                                livestockViewModel = livestockViewModel
                            )
                        }
                    }
                }

            }
        }
    }
}


