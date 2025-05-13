package com.expense.expense_tracker.presentation.ui.home.account

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.expense.expense_tracker.domain.model.Account
import com.expense.expense_tracker.domain.usecase.GetAccountsUsecase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class AccountViewModel(private val getAccountsUseCase: GetAccountsUsecase) : ViewModel() {

    private val _accounts = MutableStateFlow<List<Account>>(emptyList())
    val accounts: StateFlow<List<Account>> = _accounts

    init {
        // Fetch accounts when ViewModel is initialized
        fetchAccounts()
    }

    private fun fetchAccounts() {
        viewModelScope.launch {
            val result = getAccountsUseCase()
            _accounts.value = result
        }
    }
}