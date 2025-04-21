package com.expense.expense_tracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.compose.*
import com.expense.expense_tracker.ui.screens.HomeScreen
import com.expense.expense_tracker.ui.screens.InsertExpenseScreen
import com.expense.expense_tracker.ui.theme.ExpensetrackerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ExpenseTrackerApp()
        }
    }
}

@Composable
fun ExpenseTrackerApp() {
    val navController = rememberNavController()

    ExpensetrackerTheme {
        NavHost(navController = navController, startDestination = "home") {
            composable("home") { HomeScreen(navController) }
            composable("insert_expense") { InsertExpenseScreen(navController) }
        }
    }
}