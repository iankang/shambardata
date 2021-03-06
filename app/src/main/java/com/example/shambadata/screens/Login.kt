package com.example.shambadata.screens

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.graphics.drawable.Icon
import android.media.Image
import android.util.Log
import android.widget.Button
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.shambadata.R
import com.example.shambadata.navigation.NavRoutes
import com.example.shambadata.ui.theme.ShambaDataTheme
import com.example.shambadata.viewmodels.LoginViewModel
import com.example.shambadataapi.utils.SessionManager
import com.example.shambadataapi.models.ShambaDataResponse
import com.example.shambadataapi.models.SigninResponse
import com.example.shambadataapi.models.requests.SigninRequest
import com.example.shambadataapi.repository.ShambaDataApi
import kotlinx.coroutines.launch

@Composable
fun LoginScreen(
    navController: NavController,
    loginViewModel: LoginViewModel,
    sessionManager: SessionManager
) {

    val apiState  = loginViewModel.loginState
    val coroutineScope = rememberCoroutineScope()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.background)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center

    ) {
        var usernameText by remember { mutableStateOf(TextFieldValue("")) }
        var passwordText by remember { mutableStateOf(TextFieldValue("")) }
        var buttonClicked by remember{ mutableStateOf<Boolean>(false)}


//        if(sessionManager?.fetchAuthToken()!= null){
//            navController?.navigate(NavRoutes.AppScaffold.route)
//        }
        Image(
            painter = painterResource(id = R.drawable.ic_cow_grass),
            contentDescription = null,
            alignment = Alignment.Center
        )

        Text(
            text = "Sign in",
            style = typography.h6,
            modifier = Modifier
                .padding(16.dp)
                .align(alignment = Alignment.CenterHorizontally),
            color = MaterialTheme.colors.onBackground
        )


        OutlinedTextField(
            value = usernameText,
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = null,
                    tint = MaterialTheme.colors.onPrimary
                )
            },
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            label = { Text(text = "Email address", color = MaterialTheme.colors.onPrimary) },
            placeholder = { Text(text = "Your email", color = MaterialTheme.colors.onPrimary) },
            onValueChange = {
                usernameText = it
            },
            textStyle = androidx.compose.ui.text.TextStyle(
                color = MaterialTheme.colors.onPrimary,
                fontWeight = FontWeight.Bold
            )
        )

        // Outlined Text Input Field
        OutlinedTextField(
            value = passwordText,
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            label = { Text(text = "Password", color = MaterialTheme.colors.onPrimary) },
            visualTransformation = PasswordVisualTransformation(),
            onValueChange = {
                passwordText = it
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )

        Button(
            onClick = {
                coroutineScope.launch {
                    loginViewModel.loginRequest(usernameText.text, passwordText.text)
                    if(apiState.value.isOk){
                        navController.navigate("main")
                        sessionManager.saveAuthToken(apiState.value.data?.accessToken!!)
                    }
                }

            },
            modifier = Modifier
                .fillMaxWidth()
                .align(alignment = Alignment.CenterHorizontally),
            contentPadding = PaddingValues(8.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.secondary)
        ) {
            Text(text = "Sign in", color = MaterialTheme.colors.onSecondary)
        }

    }

}

@Composable
fun loginUser(
    shambaDataApi: ShambaDataApi?,
    username:String,
    password:String
): State<ShambaDataResponse<SigninResponse>> {
    return  produceState<ShambaDataResponse<SigninResponse>>(initialValue = ShambaDataResponse<SigninResponse>()) {
        val response =
            shambaDataApi?.signin(SigninRequest(username, password))
        if (response != null) {
            value = response
        }
    }
}

//@Preview(name = "night", uiMode = UI_MODE_NIGHT_YES, showBackground = true)
//@Preview(name = "day", uiMode = UI_MODE_NIGHT_NO, showBackground = true)
//@Composable()
//fun LoginScreenPreview() {
//    ShambaDataTheme {
//        LoginScreen(navController = null, shambaDataApi = null, sessionManager = null)
//    }
//}