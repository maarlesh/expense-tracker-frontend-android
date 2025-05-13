package com.expense.expense_tracker.presentation.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme

import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFFF8BBD0),
    secondary =  Color(0xFFF8BBD0),
    tertiary = Pink80
)

private val LightColorScheme = lightColorScheme(
    background = Color(0xFFFAFAFB),
    secondary = Color(0xffd4bff9),
    primary = Color(0xFFDFD5EC),
    surface = Color(0xff7e3ff2),
    onPrimary = Color.White,
    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

//val CustomFont = FontFamily(
//    Font(R.font.poppins_regular, FontWeight.Normal),
//    Font(R.font.poppins_medium, FontWeight.Medium),
//    Font(R.font.poppins_bold, FontWeight.Bold)
//)

@Composable
fun ExpensetrackerTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}