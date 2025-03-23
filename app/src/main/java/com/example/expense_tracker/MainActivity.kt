package com.example.expense_tracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.expense_tracker.domain.model.Account
import com.example.expense_tracker.ui.theme.ExpensetrackerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ExpenseTrackerApp()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExpenseTrackerApp() {
    ExpensetrackerTheme {
        Scaffold (
            topBar = {
                TopAppBar(
                    title = { Text("Expense Tracker") },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                        titleContentColor = MaterialTheme.colorScheme.onPrimary
                    )
                )
            },
        ){
            paddingValues ->
            Surface(modifier = Modifier.padding(paddingValues)) {
                AccountView(modifier = Modifier.padding(16.dp))
            }
        }
    }
}

@Composable
fun AccountCard(account: Account) {
    Card(
        modifier = Modifier
            .padding(8.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = account.accountName, style = MaterialTheme.typography.titleMedium)
            Text(text = "Balance: ₹${account.balance}", style = MaterialTheme.typography.bodyMedium)
        }
    }
}

@Composable
fun AccountView(modifier: Modifier = Modifier) {
    val accounts: List<Account> = listOf(
        Account("Savings Account", 1000.50, "user123"),
        Account("Checking Account", 500.75, "user456")
    )

    LazyColumn(modifier = modifier) {
        items(accounts) { account ->
            AccountCard(account)
        }
    }
}