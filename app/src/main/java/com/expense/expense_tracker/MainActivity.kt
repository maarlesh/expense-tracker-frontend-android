package com.expense.expense_tracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.compose.*
import com.expense.expense_tracker.presentation.ui.home.HomeScreen
import com.expense.expense_tracker.presentation.ui.expense.InsertExpenseScreen
import com.expense.expense_tracker.presentation.theme.ExpensetrackerTheme
import com.auth0.android.Auth0
import com.auth0.android.provider.WebAuthProvider
import com.example.expense_tracker.ui.screens.LoginScreen
import com.expense.expense_tracker.data.remote.RetrofitClient
import com.expense.expense_tracker.data.repositoryImpl.UserRepositoryImpl
import com.expense.expense_tracker.domain.model.User
import com.expense.expense_tracker.domain.usecase.LoginUserUseCase

class MainActivity : ComponentActivity() {
//    private lateinit var account: Auth0;
    override fun onCreate(savedInstanceState: Bundle?) {
//        account = Auth0.getInstance(
//            context = this,);
//        print("summa");
//        print(account);
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
    val apiService = RetrofitClient.apiService
    val userRepository = UserRepositoryImpl(apiService)
    val loginUserUseCase = LoginUserUseCase(userRepository)

    ExpensetrackerTheme {
        NavHost(navController = navController, startDestination = "login") {
            composable("login") {LoginScreen(navController,  loginUserUseCase = loginUserUseCase)}
            composable("home") { HomeScreen(navController) }
            composable("insert_expense") { InsertExpenseScreen(navController) }
        }
    }
}