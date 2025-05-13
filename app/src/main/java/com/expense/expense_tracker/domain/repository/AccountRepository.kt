package com.expense.expense_tracker.domain.repository

import com.expense.expense_tracker.domain.model.Account

interface AccountRepository {
    suspend fun getAccount() : List<Account>;
    suspend fun createAccount(account: Account);
}