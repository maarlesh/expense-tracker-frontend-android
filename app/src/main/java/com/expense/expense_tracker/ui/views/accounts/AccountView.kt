package com.expense.expense_tracker.ui.views.accounts

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.expense.expense_tracker.domain.model.Account


@Composable
fun AccountView(modifier: Modifier = Modifier) {
    val accounts: List<Account> = listOf(
        Account("HDFC", 100000.50, "user123"),
        Account("ICICI", 500.75, "user456")
    )

    Column(modifier = modifier.padding(8.dp)) {
        Text(
            text = "Accounts",
            style = MaterialTheme.typography.titleLarge,
            color = Color.Black
        )

        LazyColumn {
            items(accounts) { account ->
                AccountCard(account)
            }
        }
    }
}


@Composable
fun AccountCard(account: Account) {
    Card(
        modifier = Modifier
            .padding(vertical = 8.dp)
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.secondary,
            contentColor = MaterialTheme.colorScheme.onSurface
        ),
        elevation = CardDefaults.cardElevation(
            8.dp
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = account.accountName, style = MaterialTheme.typography.titleLarge)
            Text(text = "Balance: ₹${account.balance}", style = MaterialTheme.typography.titleMedium)
        }
    }
}