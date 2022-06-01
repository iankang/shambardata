package com.example.shambadata.screens

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.shambadata.ui.theme.ShambaDataTheme

@Composable
fun Register(navController: NavHostController?) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.background)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center

    ) {

        Text(
            text = "Register",
            style = MaterialTheme.typography.h6,
            modifier = Modifier
                .padding(8.dp)
                .align(alignment = Alignment.CenterHorizontally),
            color = MaterialTheme.colors.onBackground
        )
        var text by remember { mutableStateOf(TextFieldValue("")) }

        OutlinedTextField(
            value = text,
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            label = { Text(text = "Username", color = MaterialTheme.colors.onPrimary) },
            placeholder = { Text(text = "Username", color = MaterialTheme.colors.onPrimary) },
            onValueChange = {
                text = it
            },
            textStyle = TextStyle(
                color = MaterialTheme.colors.onPrimary,
                fontWeight = FontWeight.Bold
            )
        )


        OutlinedTextField(
            value = text,
            leadingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription = null, tint = MaterialTheme.colors.onPrimary) },
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            label = { Text(text = "Email address", color = MaterialTheme.colors.onPrimary) },
            placeholder = { Text(text = "Your email", color = MaterialTheme.colors.onPrimary) },
            onValueChange = {
                text = it
            },
            textStyle = TextStyle(
                color = MaterialTheme.colors.onPrimary,
                fontWeight = FontWeight.Bold
            )
        )

        OutlinedTextField(
            value = text,
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            label = { Text(text = "First Name", color = MaterialTheme.colors.onPrimary) },
            placeholder = { Text(text = "First Name", color = MaterialTheme.colors.onPrimary) },
            onValueChange = {
                text = it
            },
            textStyle = TextStyle(
                color = MaterialTheme.colors.onPrimary,
                fontWeight = FontWeight.Bold
            )
        )
        OutlinedTextField(
            value = text,
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            label = { Text(text = "Last Name", color = MaterialTheme.colors.onPrimary) },
            placeholder = { Text(text = "Last Name", color = MaterialTheme.colors.onPrimary) },
            onValueChange = {
                text = it
            },
            textStyle = TextStyle(
                color = MaterialTheme.colors.onPrimary,
                fontWeight = FontWeight.Bold
            )
        )
        // Outlined Text Input Field
        OutlinedTextField(
            value = text,
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            label = { Text(text = "Password", color = MaterialTheme.colors.onPrimary) },
            placeholder = { Text(text = "12334444", color = MaterialTheme.colors.onPrimary) },
            visualTransformation = PasswordVisualTransformation(),
            onValueChange = {
                text = it
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )


        OutlinedTextField(
            value = text,
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            label = { Text(text = "Confirm Password", color = MaterialTheme.colors.onPrimary) },
            placeholder = { Text(text = "12334444", color = MaterialTheme.colors.onPrimary) },
            visualTransformation = PasswordVisualTransformation(),
            onValueChange = {
                text = it
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )

        Button(
            onClick = {
                Log.e("clicked", "Clicked")
                navController?.navigate("Home")
            },
            modifier = Modifier
                .fillMaxWidth()
                .align(alignment = Alignment.CenterHorizontally),
            colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.secondary)

            ) {
            Text(text = "Register", color = MaterialTheme.colors.onSecondary)
        }
    }
}

@Composable
@Preview(name = "day", uiMode = UI_MODE_NIGHT_NO)
@Preview(name = "night", uiMode = UI_MODE_NIGHT_YES)
fun RegisterPreview(navController: NavHostController? = null) {
    ShambaDataTheme {
        Register(null)
    }
}
