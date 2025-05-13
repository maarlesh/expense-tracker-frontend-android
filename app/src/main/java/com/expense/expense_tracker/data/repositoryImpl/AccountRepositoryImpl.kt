package com.expense.expense_tracker.data.repositoryImpl

import com.expense.expense_tracker.data.remote.ApiService
import com.expense.expense_tracker.domain.model.Account
import com.expense.expense_tracker.domain.repository.AccountRepository

class AccountRepositoryImpl (private val apiService : ApiService) : AccountRepository {
    override suspend fun getAccount(): List<Account> {
        return apiService.getAccounts("1");
    }

    override suspend fun createAccount(account: Account) {
        TODO("Not yet implemented")
    }
}