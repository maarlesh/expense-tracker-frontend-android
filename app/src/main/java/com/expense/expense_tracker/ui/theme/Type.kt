package com.expense.expense_tracker.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.expense_tracker.R

// Set of Material typography styles to start with

val Poppins = FontFamily(
    Font(R.font.poppins_regular, FontWeight.Normal),
)

val OpenSans = FontFamily(
    Font(R.font.open_sans)
)

val LatoBlack = FontFamily(
    Font(R.font.lato_black)
)

val LatoRegular = FontFamily(
    Font(R.font.lato_regular)
)

val Inter = FontFamily(
    Font(R.font.inter)
)

val Typography = Typography(
    titleLarge = TextStyle(
        fontFamily = Inter,
        fontSize = 24.sp
    ),
    titleMedium = TextStyle(
        fontFamily = Inter,
        fontSize = 18.sp
    )
)