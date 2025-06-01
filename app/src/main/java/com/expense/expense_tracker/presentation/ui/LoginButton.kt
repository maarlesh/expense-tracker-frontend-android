package com.expense.expense_tracker.presentation.ui

import android.graphics.fonts.FontStyle
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun LoginButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    var isPressed by remember { mutableStateOf(false) }

    val scale by animateFloatAsState(
        targetValue = if (isPressed) 0.96f else 1f,
        label = "button-scale"
    )

    if (isPressed) {
        LaunchedEffect(isPressed) {
            kotlinx.coroutines.delay(100)
            isPressed = false
            onClick()
        }
    }

    Button(
        onClick = { isPressed = true },
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.surface,
            contentColor = Color.White
        ),
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 6.dp,
            pressedElevation = 2.dp
        ),
        modifier = modifier
            .fillMaxWidth()
            .scale(scale)
    ) {
        Text("Login", style = MaterialTheme.typography.titleSmall)
    }
}