package com.example.shambadata

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.produceState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.shambadata.ui.theme.ShambaDataTheme
import com.example.shambadataapi.models.ShambaDataResponse
import com.example.shambadataapi.models.SigninResponse
import com.example.shambadataapi.models.requests.SigninRequest
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

                    val shambaState by produceState(initialValue = ShambaDataResponse<SigninResponse>()) {
                        val response =
                            shambaDataApi.signin(SigninRequest("ianngech@gmail.com", "kangethe"))
                        value = response
                    }
                    if(shambaState.isOk){
                        Greeting(shambaState.data.toString())
                    }
                    if(shambaState.isOk == false){
                        Greeting("loading")
                    }
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