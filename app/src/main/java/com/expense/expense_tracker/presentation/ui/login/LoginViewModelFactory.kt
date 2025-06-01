package com.expense.expense_tracker.presentation.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.expense.expense_tracker.domain.usecase.LoginUserUseCase

class LoginViewModelFactory(
    private val loginUserUseCase: LoginUserUseCase
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            return LoginViewModel(loginUserUseCase) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
