package com.example.shambadata.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key.Companion.G

private val DarkColorPalette = darkColors(
    primary = Grey500,
    primaryVariant = Grey700,
    secondary = Green500,
    secondaryVariant = Green700,
    onSecondary = Color.Black,
    onPrimary = Color.White,
    background = Grey500,
    onBackground = Color.White,
    surface = Green500,
    onSurface = Color.Black,
    error = Color.Red,
    onError = Color.White
)

private val LightColorPalette = lightColors(
    primary = LightGrey500,
    primaryVariant = LightGrey700,
    secondary = Green500,
    secondaryVariant = Green200,
    onPrimary = Color.Black,
    background = LightGrey500,
    onBackground = Color.Black,
    surface = Green200,
    onSurface = Color.Black,
    error = Color.Red,
    onError = Color.White,
    onSecondary = Color.Black


    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun ShambaDataTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}