package com.expense.expense_tracker.presentation.ui.home.account

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.expense.expense_tracker.domain.usecase.GetAccountsUsecase

class AccountViewModelFactory(
    private val getAccountsUseCase: GetAccountsUsecase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(AccountViewModel::class.java)) {
            AccountViewModel(getAccountsUseCase) as T
        } else {
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}
