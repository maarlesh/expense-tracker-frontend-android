package com.expense.expense_tracker.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme

import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.expense_tracker.R

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