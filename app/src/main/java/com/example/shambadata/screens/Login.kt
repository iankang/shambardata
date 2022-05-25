package com.example.shambadata.screens

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.typography
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
import com.example.shambadata.ui.theme.ShambaDataTheme

@Composable
fun LoginScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(color = MaterialTheme.colors.background),
        verticalArrangement = Arrangement.Center

    ) {

        Text(
            text = "Sign in",
            style = typography.h6,
            modifier = Modifier.padding(8.dp).align(alignment = Alignment.CenterHorizontally),
            color = MaterialTheme.colors.onBackground
        )
        var text by remember { mutableStateOf(TextFieldValue("")) }

        OutlinedTextField(
            value = text,
            leadingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription = null) },
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            label = { Text(text = "Email address") },
            placeholder = { Text(text = "Your email") },
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
            label = { Text(text = "Password") },
            placeholder = { Text(text = "12334444") },
            visualTransformation = PasswordVisualTransformation(),
            onValueChange = {
                text = it
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )

        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .fillMaxWidth(0.7f)
                .align(alignment = Alignment.CenterHorizontally),

        ) {
            Text(text = "Sign in", color = MaterialTheme.colors.onPrimary)
        }

    }
}

@Preview(name = "night", uiMode = UI_MODE_NIGHT_YES, showBackground = true)
@Preview(name = "day", uiMode = UI_MODE_NIGHT_NO, showBackground = true)
@Composable()
fun LoginScreenPreview() {
    ShambaDataTheme {
        LoginScreen()
    }
}