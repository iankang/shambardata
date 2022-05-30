package com.example.shambadata

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.shambadata.navigation.NavRoutes
import com.example.shambadata.screens.HomeScreen
import com.example.shambadata.screens.LoginScreen
import com.example.shambadata.screens.Register
import com.example.shambadata.ui.theme.ShambaDataTheme
import com.example.shambadataapi.repository.ShambaDataApi
import org.koin.android.ext.android.inject

class MainActivity : ComponentActivity() {

    private val shambaDataApi: ShambaDataApi by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShambaDataTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = NavRoutes.Login.route,
                    ) {
                        composable(NavRoutes.Login.route) {
                            LoginScreen(navController = navController)
                        }
                        composable(NavRoutes.Register.route) {
                            Register(navController = navController)
                        }
                        composable(NavRoutes.Home.route) {
                            HomeScreen()
                        }

                    }

//                    val shambaState by produceState(initialValue = ShambaDataResponse<SigninResponse>()) {
//                        val response =
//                            shambaDataApi.signin(SigninRequest("ianngech@gmail.com", "kangethe"))
//                        value = response
//                    }
//                    if(shambaState.isOk){
//                        Greeting(shambaState.data.toString())
//                    }
//                    if(shambaState.isOk == false){
//                        Greeting("loading")
//                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ShambaDataTheme {
        Greeting("Android")
    }
}