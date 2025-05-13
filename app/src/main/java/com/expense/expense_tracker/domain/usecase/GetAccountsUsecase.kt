package com.expense.expense_tracker.domain.usecase

import com.expense.expense_tracker.domain.repository.AccountRepository
import com.expense.expense_tracker.domain.model.Account

class GetAccountsUsecase(private val repo: AccountRepository) {
    suspend operator fun invoke(): List<Account> = repo.getAccount();
}