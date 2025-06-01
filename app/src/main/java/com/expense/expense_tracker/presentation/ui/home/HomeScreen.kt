package com.expense.expense_tracker.presentation.ui.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.expense.expense_tracker.data.remote.ApiService
import com.expense.expense_tracker.data.remote.RetrofitClient
import com.expense.expense_tracker.data.repositoryImpl.AccountRepositoryImpl
import com.expense.expense_tracker.domain.usecase.GetAccountsUsecase
import com.expense.expense_tracker.presentation.ui.home.account.AccountScreen
import com.expense.expense_tracker.presentation.ui.home.account.AccountViewModel
import com.expense.expense_tracker.presentation.ui.home.account.AccountViewModelFactory

@SuppressLint("ViewModelConstructorInComposable")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Expense Tracker") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surface,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                navController.navigate("insert_expense")
            }) {
                Icon(Icons.Filled.Add, contentDescription = "Add Expense")
            }
        }
    ) { paddingValues ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            color = MaterialTheme.colorScheme.background
        ) {
            val apiService = RetrofitClient.apiService
            val accountRepository = AccountRepositoryImpl(apiService)
            val getAccountsUseCase = GetAccountsUsecase(accountRepository)

            val accountViewModel: AccountViewModel = viewModel(
                factory = AccountViewModelFactory(getAccountsUseCase)
            )

            // Observe data from ViewModel
            val accounts by accountViewModel.accounts.collectAsState()

            // Pass data to AccountScreen
            AccountScreen(modifier = Modifier.padding(16.dp), accounts = accounts)

        }
    }
}